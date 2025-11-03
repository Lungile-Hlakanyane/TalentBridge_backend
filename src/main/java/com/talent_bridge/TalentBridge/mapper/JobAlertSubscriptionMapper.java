package com.talent_bridge.TalentBridge.mapper;
import com.talent_bridge.TalentBridge.DTO.JobAlertSubscriptionDTO;
import com.talent_bridge.TalentBridge.entity.JobAlertSubscription;
import org.springframework.stereotype.Component;

@Component
public class JobAlertSubscriptionMapper {
    public static JobAlertSubscription toEntity(JobAlertSubscriptionDTO dto) {
        return new JobAlertSubscription(
                dto.getUserId(),
                dto.getEmail(),
                dto.getJobRole()
        );
    }
    public static JobAlertSubscriptionDTO toDTO(JobAlertSubscription entity) {
        return new JobAlertSubscriptionDTO(
                entity.getUserId(),
                entity.getEmail(),
                entity.getJobRole()
        );
    }
}
