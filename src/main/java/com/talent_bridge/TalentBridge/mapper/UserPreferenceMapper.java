package com.talent_bridge.TalentBridge.mapper;
import com.talent_bridge.TalentBridge.DTO.UserPreferenceDTO;
import com.talent_bridge.TalentBridge.entity.UserPreference;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UserPreferenceMapper {
    public static UserPreference toEntity(UserPreferenceDTO dto) {
        UserPreference entity = new UserPreference();
        entity.setUserId(dto.getUserId());
        entity.setIndustries(dto.getIndustries());
        entity.setJobTypes(dto.getJobTypes());
        entity.setExperienceLevels(dto.getExperienceLevels());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return entity;
    }

    public static UserPreferenceDTO toDTO(UserPreference entity) {
        UserPreferenceDTO dto = new UserPreferenceDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setIndustries(entity.getIndustries());
        dto.setJobTypes(entity.getJobTypes());
        dto.setExperienceLevels(entity.getExperienceLevels());
        return dto;
    }
    public static void updateEntityFromDTO(UserPreferenceDTO dto, UserPreference entity) {
        if (dto.getIndustries() != null) entity.setIndustries(dto.getIndustries());
        if (dto.getJobTypes() != null) entity.setJobTypes(dto.getJobTypes());
        if (dto.getExperienceLevels() != null) entity.setExperienceLevels(dto.getExperienceLevels());
        entity.setUpdatedAt(LocalDateTime.now());
    }
}
