package com.talent_bridge.TalentBridge.service;
import com.talent_bridge.TalentBridge.DTO.JobApplicationDTO;
import com.talent_bridge.TalentBridge.entity.JobApplication;
import java.util.List;

public interface JobApplicationService {
    JobApplication applyForJob(JobApplicationDTO dto);
    List<JobApplication> getApplicationsForJob(Long jobId);
    List<JobApplication> getApplicationsForUser(String email);
}
