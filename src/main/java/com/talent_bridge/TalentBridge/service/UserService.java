package com.talent_bridge.TalentBridge.service;
import com.talent_bridge.TalentBridge.DTO.LoginDTO;
import com.talent_bridge.TalentBridge.DTO.UserDTO;
import com.talent_bridge.TalentBridge.entity.User;

public interface UserService {
    void createUser(UserDTO dto);
    boolean activateAccount(String token);
    User login(LoginDTO loginDTO) throws Exception;
}
