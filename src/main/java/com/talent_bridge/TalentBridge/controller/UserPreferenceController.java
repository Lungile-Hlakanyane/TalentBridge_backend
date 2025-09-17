package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.UserPreferenceDTO;
import com.talent_bridge.TalentBridge.service.UserPreferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferences")
public class UserPreferenceController {
    private final UserPreferenceService service;
    public UserPreferenceController(UserPreferenceService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createOrUpdate(@RequestBody UserPreferenceDTO dto) {
        if (dto.getUserId() == null || dto.getUserId().isBlank()) {
            return ResponseEntity.badRequest().body("userId is required");
        }
        UserPreferenceDTO saved = service.createPreference(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getByUser(@PathVariable String userId) {
        return service.getByUserId(userId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserPreferenceDTO dto) {
        return service.updatePreference(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deletePreference(id);
        return ResponseEntity.ok().build();
    }
}
