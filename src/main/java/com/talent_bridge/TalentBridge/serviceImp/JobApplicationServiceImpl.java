package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.JobApplicationDTO;
import com.talent_bridge.TalentBridge.entity.JobApplication;
import com.talent_bridge.TalentBridge.mapper.JobApplicationMapper;
import com.talent_bridge.TalentBridge.repository.JobApplicationRepository;
import com.talent_bridge.TalentBridge.service.JobApplicationService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
    private final JobApplicationRepository repository;
    private final JobApplicationMapper mapper;

    public JobApplicationServiceImpl(JobApplicationRepository repository, JobApplicationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public JobApplication applyForJob(JobApplicationDTO dto) {
        JobApplication application = mapper.toEntity(dto);
        application.setAppliedAt(LocalDateTime.now());
        return repository.save(application);
    }

    @Override
    public List<JobApplication> getApplicationsForJob(Long jobId) {
        return repository.findByJobId(jobId);
    }

    @Override
    public List<JobApplication> getApplicationsForUser(String email) {
        return repository.findByApplicantEmail(email);
    }
}
