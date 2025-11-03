package com.talent_bridge.TalentBridge.service;
import com.talent_bridge.TalentBridge.DTO.JobDTO;
import java.util.List;

public interface JobService {
    JobDTO createJob(JobDTO jobDTO);
    JobDTO getJobById(Long id);
    List<JobDTO> getAllJobs();
    List<JobDTO> getJobsByUserId(Long userId);
    JobDTO updateJob(Long id, JobDTO jobDTO);
    void deleteJob(Long id);
    JobDTO changeApprovalStatus(Long id, boolean approve, String status);
}
