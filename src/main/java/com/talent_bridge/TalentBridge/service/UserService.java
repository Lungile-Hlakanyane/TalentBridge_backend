package com.talent_bridge.TalentBridge.service;
import com.talent_bridge.TalentBridge.DTO.LoginDTO;
import com.talent_bridge.TalentBridge.DTO.UserDTO;
import com.talent_bridge.TalentBridge.entity.User;
import com.talent_bridge.TalentBridge.enums.Role;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    void createUser(UserDTO dto);
    boolean activateAccount(String token);
    User login(LoginDTO loginDTO) throws Exception;
    User getUserById(Long id);
    long countByRole(Role role);
    List<User> getAllEmployers();
    List<User> getAllEmployees();
    public byte[] getResumeFile(Long userId);
    void initiatePasswordReset(String email);
    boolean verifyResetCode(String email, String code);
    void resetPassword(String email, String code, String newPassword);
    Optional<User> getUserByEmail(String email);
    void updateOnlineStatus(Long userId, boolean online);
    List<User> getAllUsers();
    void deleteUserById(Long userId);
}
