package com.talent_bridge.TalentBridge.service;
import com.talent_bridge.TalentBridge.DTO.JobAlertSubscriptionDTO;
import java.util.List;

public interface JobAlertSubscriptionService {
    JobAlertSubscriptionDTO createSubscription(JobAlertSubscriptionDTO dto);
    List<JobAlertSubscriptionDTO> getSubscriptionsByUser(Long userId);
    List<JobAlertSubscriptionDTO> getSubscriptionsByRole(String jobRole);
}
