package com.talent_bridge.TalentBridge.mapper;
import com.talent_bridge.TalentBridge.DTO.JobDTO;
import com.talent_bridge.TalentBridge.entity.Job;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {
    public static JobDTO toDTO(Job job) {
        if (job == null) return null;
        return new JobDTO(
                job.getId(),
                job.getTitle(),
                job.getCompany(),
                job.getLocation(),
                job.getType(),
                job.getSalary(),
                job.getDescription(),
                job.getUserId(),
                job.getCreated(),
                job.isApprove(),
                job.getStatus()
        );
    }

    public static Job toEntity(JobDTO jobDTO) {
        if (jobDTO == null) return null;
        Job job = new Job(
                jobDTO.getId(),
                jobDTO.getTitle(),
                jobDTO.getCompany(),
                jobDTO.getLocation(),
                jobDTO.getType(),
                jobDTO.getSalary(),
                jobDTO.getDescription(),
                jobDTO.getUserId(),
                jobDTO.getCreated()
        );
        job.setApprove(jobDTO.isApprove());
        job.setStatus(jobDTO.getStatus());
        return job;
    }
}
