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
        application.setApplicantEmail(dto.getApplicantEmail());
        application.setApplicantName(dto.getApplicantName());
        application.setResumePath(dto.getResumePath());
        return application;
    }
    public JobApplicationDTO toDTO(JobApplication entity) {
        JobApplicationDTO dto = new JobApplicationDTO();
        dto.setJobId(entity.getJobId());
        dto.setApplicantName(entity.getApplicantName());
        dto.setApplicantEmail(entity.getApplicantEmail());
        dto.setCoverLetter(entity.getCoverLetter());
        dto.setResumePath(entity.getResumePath());
        return dto;
    }
}
