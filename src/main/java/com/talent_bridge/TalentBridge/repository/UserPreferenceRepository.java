package com.talent_bridge.TalentBridge.repository;
import com.talent_bridge.TalentBridge.entity.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
    Optional<UserPreference> findByUserId(String userId);
}
