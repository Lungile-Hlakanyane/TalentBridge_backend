package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.UserPreferenceDTO;
import com.talent_bridge.TalentBridge.entity.UserPreference;
import com.talent_bridge.TalentBridge.mapper.UserPreferenceMapper;
import com.talent_bridge.TalentBridge.repository.UserPreferenceRepository;
import com.talent_bridge.TalentBridge.service.UserPreferenceService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserPreferenceServiceImp implements UserPreferenceService {
    private final UserPreferenceRepository repository;
    public UserPreferenceServiceImp(UserPreferenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserPreferenceDTO createPreference(UserPreferenceDTO dto) {
        Optional<UserPreference> existing = repository.findByUserId(dto.getUserId());
        UserPreference entity;
        if (existing.isPresent()) {
            entity = existing.get();
            UserPreferenceMapper.updateEntityFromDTO(dto, entity);
        } else {
            entity = UserPreferenceMapper.toEntity(dto);
        }
        UserPreference saved = repository.save(entity);
        return UserPreferenceMapper.toDTO(saved);
    }

    @Override
    public Optional<UserPreferenceDTO> getByUserId(String userId) {
        return repository.findByUserId(userId).map(UserPreferenceMapper::toDTO);
    }

    @Override
    public Optional<UserPreferenceDTO> updatePreference(Long id, UserPreferenceDTO dto) {
        return repository.findById(id).map(entity -> {
            UserPreferenceMapper.updateEntityFromDTO(dto, entity);
            repository.save(entity);
            return UserPreferenceMapper.toDTO(entity);
        });
    }

    @Override
    public void deletePreference(Long id) {
        repository.deleteById(id);
    }
}
