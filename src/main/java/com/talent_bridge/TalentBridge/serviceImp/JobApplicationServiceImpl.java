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
    private final EmailService emailService;

    public JobApplicationServiceImpl(JobApplicationRepository repository, JobApplicationMapper mapper, EmailService emailService) {
        this.repository = repository;
        this.mapper = mapper;
        this.emailService = emailService;
    }

    @Override
    public JobApplication applyForJob(JobApplicationDTO dto) {
        JobApplication application = new JobApplication();
        application.setJobId(dto.getJobId()); // ✅ FIXED
        application.setApplicantName(dto.getApplicantName());
        application.setApplicantEmail(dto.getApplicantEmail());
        application.setCoverLetter(dto.getCoverLetter());
        application.setResumePath(dto.getResumePath());
        application.setAppliedAt(LocalDateTime.now());

        JobApplication saved = repository.save(application);

        // Send confirmation email
        emailService.sendApplicationConfirmation(
                dto.getApplicantEmail(),
                dto.getApplicantName(),
                dto.getApplicantEmail()
        );
        return saved;
    }

    @Override
    public List<JobApplication> getApplicationsForJob(Long jobId) {
        return repository.findByJobId(jobId);
    }

    @Override
    public List<JobApplication> getApplicationsForUser(String email) {
        return repository.findByApplicantEmail(email);
    }

    @Override
    public JobApplicationDTO getApplicationById(Long id) {
        JobApplication application = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));
        JobApplicationDTO dto = new JobApplicationDTO();
        dto.setJobId(application.getId());
        dto.setApplicantName(application.getApplicantName());
        dto.setApplicantEmail(application.getApplicantEmail());
        dto.setCoverLetter(application.getCoverLetter());
        dto.setJobId(application.getJobId());
        dto.setResumePath(application.getResumePath());
        return dto;
    }
}
