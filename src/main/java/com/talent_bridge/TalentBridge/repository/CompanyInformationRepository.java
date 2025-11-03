package com.talent_bridge.TalentBridge.repository;
import com.talent_bridge.TalentBridge.entity.CompanyInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompanyInformationRepository extends JpaRepository<CompanyInformation, Long> {
    Optional<CompanyInformation> findByUserId(Long userId);
}
