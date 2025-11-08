package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.LoginDTO;
import com.talent_bridge.TalentBridge.DTO.UserDTO;
import com.talent_bridge.TalentBridge.entity.User;
import com.talent_bridge.TalentBridge.enums.Role;
import com.talent_bridge.TalentBridge.mapper.UserMapper;
import com.talent_bridge.TalentBridge.repository.UserRepository;
import com.talent_bridge.TalentBridge.service.UserService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final JavaMailSender mailSender;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public UserServiceImp(UserRepository userRepository, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    @Override
    public void createUser(UserDTO dto) {
        String token = UUID.randomUUID().toString();
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        String resumePath = String.valueOf(dto.getResume());
        User user = UserMapper.toEntity(dto, resumePath, hashedPassword, token);
        user.setTokenExpiry(LocalDateTime.now().plusHours(24));
        userRepository.save(user);
        sendActivationEmail(dto.getEmail(), token);
    }

    @Override
    public boolean activateAccount(String token) {
        return userRepository.findByActivationToken(token)
                .map(user -> {
                    if (user.getTokenExpiry().isBefore(LocalDateTime.now())) {
                        throw new RuntimeException("Activation token expired");
                    }
                    user.setActivated(true);
                    user.setActivationToken(null);
                    userRepository.save(user);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public User login(LoginDTO loginDTO) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmail(loginDTO.getEmail());
        if (!optionalUser.isPresent()) {
            throw new Exception("Invalid email or password");
        }
        User user = optionalUser.get();
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new Exception("Invalid email or password");
        }
        if (!user.isActivated()) {
            throw new Exception("Account not activated. Please check your email.");
        }
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    @Override
    public long countByRole(Role role) {
        return userRepository.countByRole(role);
    }

    @Override
    public List<User> getAllEmployers() {
        return userRepository.findByRole(Role.EMPLOYER);
    }

    @Override
    public List<User> getAllEmployees() {
        return userRepository.findByRole(Role.EMPLOYEE);
    }

    @Override
    public byte[] getResumeFile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getResumePath().getBytes();
    }

    @Override
    public void initiatePasswordReset(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        String code = String.format("%06d", (int) (Math.random() * 1000000));
        user.setResetCode(code);
        user.setResetCodeExpiry(LocalDateTime.now().plusMinutes(15));
        userRepository.save(user);
        sendResetCodeEmail(email, code);
    }

    @Override
    public boolean verifyResetCode(String email, String code) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        if (user.getResetCode() == null || !user.getResetCode().equals(code)) {
            return false;
        }
        if (user.getResetCodeExpiry().isBefore(LocalDateTime.now())) {
            return false;
        }
        return true;
    }

    @Override
    public void resetPassword(String email, String code, String newPassword) {
        if (!verifyResetCode(email, code)) {
            throw new RuntimeException("Invalid or expired reset code");
        }
        User user = userRepository.findByEmail(email).get();
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetCode(null);
        user.setResetCodeExpiry(null);
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private void sendActivationEmail(String email, String token) {
        String activationLink = "http://localhost:8080/api/users/activate?token=" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("TalentBridge Account Activation");
        message.setText("Welcome to TalentBridge!\n\nPlease click the link below to activate your account:\n"
                + activationLink + "\n\nThis link expires in 24 hours.");
        mailSender.send(message);
    }

    private void sendResetCodeEmail(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("TalentBridge Password Reset Code");
        message.setText("Your password reset code is: " + code + "\nThis code is valid for 15 minutes.");
        mailSender.send(message);
    }
}
