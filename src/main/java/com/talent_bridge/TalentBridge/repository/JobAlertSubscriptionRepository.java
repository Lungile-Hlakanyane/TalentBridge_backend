package com.talent_bridge.TalentBridge.repository;
import com.talent_bridge.TalentBridge.entity.JobAlertSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobAlertSubscriptionRepository extends JpaRepository<JobAlertSubscription, Long> {
    List<JobAlertSubscription> findByJobRole(String jobRole);
    List<JobAlertSubscription> findByUserId(Long userId);
}
