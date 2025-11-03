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
    public JobAlertSubscriptionServiceImpl(JobAlertSubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobAlertSubscriptionDTO createSubscription(JobAlertSubscriptionDTO dto) {
        JobAlertSubscription entity = JobAlertSubscriptionMapper.toEntity(dto);
        JobAlertSubscription saved = repository.save(entity);
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
}
