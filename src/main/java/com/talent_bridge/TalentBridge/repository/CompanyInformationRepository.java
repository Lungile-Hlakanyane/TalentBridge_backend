package com.talent_bridge.TalentBridge.repository;
import com.talent_bridge.TalentBridge.entity.CompanyInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CompanyInformationRepository extends JpaRepository<CompanyInformation, Long> {
    Optional<CompanyInformation> findByUserId(Long userId);
}
