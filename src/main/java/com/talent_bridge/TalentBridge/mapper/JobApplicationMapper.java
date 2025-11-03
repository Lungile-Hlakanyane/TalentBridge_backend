package com.talent_bridge.TalentBridge.mapper;
import com.talent_bridge.TalentBridge.DTO.JobApplicationDTO;
import com.talent_bridge.TalentBridge.entity.JobApplication;
import org.springframework.stereotype.Component;

@Component
public class JobApplicationMapper {
    public JobApplication toEntity(JobApplicationDTO dto) {
        JobApplication application = new JobApplication();
        application.setJobId(dto.getJobId());
        application.setApplicantName(dto.getApplicantName());
        application.setApplicantEmail(dto.getApplicantEmail());
        application.setCoverLetter(dto.getCoverLetter());
        application.setResumePath(dto.getResumePath());
        return application;
    }
    public JobApplicationDTO toDTO(JobApplication entity) {
        return new JobApplicationDTO(
                entity.getJobId(),
                entity.getApplicantName(),
                entity.getApplicantEmail(),
                entity.getCoverLetter(),
                entity.getResumePath()
        );
    }
}
