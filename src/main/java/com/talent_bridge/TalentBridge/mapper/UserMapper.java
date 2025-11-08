package com.talent_bridge.TalentBridge.mapper;
import com.talent_bridge.TalentBridge.DTO.UserDTO;
import com.talent_bridge.TalentBridge.entity.User;
import com.talent_bridge.TalentBridge.enums.Role;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UserMapper {
    public static User toEntity(UserDTO dto, String resumePath, String hashedPassword, String token) {
        User user = new User();
        user.setResumePath(resumePath);
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setRole(Role.valueOf(dto.getRole().toUpperCase()));
        user.setCompanyName(dto.getCompanyName());
        user.setPassword(hashedPassword);
        user.setActivated(false);
        user.setActivationToken(token);
        user.setResetCode(dto.getResetCode());
        user.setResetCodeExpiry(dto.getResetCodeExpiry());
        user.setTokenExpiry(LocalDateTime.now().plusDays(1));
        return user;
    }
}
