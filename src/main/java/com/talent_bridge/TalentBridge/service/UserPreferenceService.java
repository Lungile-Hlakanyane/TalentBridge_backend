package com.talent_bridge.TalentBridge.service;
import com.talent_bridge.TalentBridge.DTO.UserPreferenceDTO;
import java.util.Optional;

public interface UserPreferenceService {
    UserPreferenceDTO createPreference(UserPreferenceDTO dto);
    Optional<UserPreferenceDTO> getByUserId(String userId);
    Optional<UserPreferenceDTO> updatePreference(Long id, UserPreferenceDTO dto);
    void deletePreference(Long id);
}
