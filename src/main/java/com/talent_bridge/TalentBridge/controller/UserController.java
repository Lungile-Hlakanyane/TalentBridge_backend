package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.LoginDTO;
import com.talent_bridge.TalentBridge.DTO.LoginResponseDTO;
import com.talent_bridge.TalentBridge.DTO.UserDTO;
import com.talent_bridge.TalentBridge.entity.User;
import com.talent_bridge.TalentBridge.enums.Role;
import com.talent_bridge.TalentBridge.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(value = "/create", consumes = {"multipart/form-data"})
    public ResponseEntity<String> createUser(
            @RequestPart( value="resume", required= false) MultipartFile resume,
            @RequestPart("name") String name,
            @RequestPart("surname") String surname,
            @RequestPart("email") String email,
            @RequestPart("phone") String phone,
            @RequestPart("address") String address,
            @RequestPart("role") String role,
            @RequestPart(value = "companyName", required = false) String companyName,
            @RequestPart("password") String password,
            @RequestPart("confirmPassword") String confirmPassword
    ) {
        UserDTO dto = new UserDTO();
        dto.setResume(resume);
        dto.setName(name);
        dto.setSurname(surname);
        dto.setEmail(email);
        dto.setPhone(phone);
        dto.setAddress(address);
        dto.setRole(role);
        dto.setCompanyName(companyName);
        dto.setPassword(password);
        dto.setConfirmPassword(confirmPassword);

        userService.createUser(dto);

        return ResponseEntity.ok("User created! Please check your email for activation link.");
    }
    @GetMapping("/activate")
    public ResponseEntity<String> activate(@RequestParam String token) {
        boolean activated = userService.activateAccount(token);
        if (activated) {
            return ResponseEntity.ok("Account successfully activated!");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired activation token.");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            User user = userService.login(loginDTO);
            LoginResponseDTO response = new LoginResponseDTO(user.getId(), user.getRole().toString());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching user: " + e.getMessage());
        }
    }

    @GetMapping("/count/employers")
    public ResponseEntity<Long> countEmployers() {
        long count = userService.countByRole(Role.EMPLOYER);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/count/employees")
    public ResponseEntity<Long> countEmployees() {
        long count = userService.countByRole(Role.EMPLOYEE);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/employers")
    public ResponseEntity<List<User>> getAllEmployers() {
        List<User> employers = userService.getAllEmployers();
        return ResponseEntity.ok(employers);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<User>> getAllEmployees() {
        List<User> employers = userService.getAllEmployees();
        return ResponseEntity.ok(employers);
    }

    @GetMapping("/download-resume/{userId}")
    public ResponseEntity<byte[]> downloadResume(@PathVariable Long userId) {
        byte[] resumeData = userService.getResumeFile(userId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=resume.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resumeData);
    }

}
