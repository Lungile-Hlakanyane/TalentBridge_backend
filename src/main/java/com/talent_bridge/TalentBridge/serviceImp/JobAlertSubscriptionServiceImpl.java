package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.JobAlertSubscriptionDTO;
import com.talent_bridge.TalentBridge.entity.JobAlertSubscription;
import com.talent_bridge.TalentBridge.mapper.JobAlertSubscriptionMapper;
import com.talent_bridge.TalentBridge.repository.JobAlertSubscriptionRepository;
import com.talent_bridge.TalentBridge.service.JobAlertSubscriptionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobAlertSubscriptionServiceImpl implements JobAlertSubscriptionService {
    private final JobAlertSubscriptionRepository repository;
    private final EmailService emailService;
    public JobAlertSubscriptionServiceImpl(JobAlertSubscriptionRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @Override
    public JobAlertSubscriptionDTO createSubscription(JobAlertSubscriptionDTO dto) {
        JobAlertSubscription entity = JobAlertSubscriptionMapper.toEntity(dto);
        JobAlertSubscription saved = repository.save(entity);

        //send confirmation email
        sendSubscriptionConfirmationEmail(saved);

        return JobAlertSubscriptionMapper.toDTO(saved);
    }

    @Override
    public List<JobAlertSubscriptionDTO> getSubscriptionsByUser(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(JobAlertSubscriptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<JobAlertSubscriptionDTO> getSubscriptionsByRole(String jobRole) {
        return repository.findByJobRole(jobRole)
                .stream()
                .map(JobAlertSubscriptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    //Helper method for email subscription confirmation
    private void sendSubscriptionConfirmationEmail(JobAlertSubscription subscription) {
        String subject = "Job Alert Subscription Confirmation";

        String body = String.format("""
                Dear %s,
                
                You have successfully subscribed to job alerts for the following role:
                • %s
                
                We'll notify you via email when new opportunities matching this role become available.
                
                Next step: Stay tuned for job alerts that match your interest!
                
                Best regards,
                TalentBridge Team
                """,
                // Extracting name if available — fallback to email
                subscription.getEmail().contains("@")
                        ? subscription.getEmail().split("@")[0]
                        : subscription.getEmail(),
                subscription.getJobRole()
        );

        emailService.sendEmail(subscription.getEmail(), subject, body);
    }
}
