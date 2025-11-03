package com.talent_bridge.TalentBridge.service;
import com.talent_bridge.TalentBridge.DTO.LoginDTO;
import com.talent_bridge.TalentBridge.DTO.UserDTO;
import com.talent_bridge.TalentBridge.entity.User;
import com.talent_bridge.TalentBridge.enums.Role;

import java.util.List;

public interface UserService {
    void createUser(UserDTO dto);
    boolean activateAccount(String token);
    User login(LoginDTO loginDTO) throws Exception;
    User getUserById(Long id);
    long countByRole(Role role);
    List<User> getAllEmployers();
    List<User> getAllEmployees();
}
