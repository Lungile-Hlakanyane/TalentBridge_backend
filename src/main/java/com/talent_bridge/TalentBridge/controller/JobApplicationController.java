package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.JobApplicationDTO;
import com.talent_bridge.TalentBridge.entity.JobApplication;
import com.talent_bridge.TalentBridge.repository.JobApplicationRepository;
import com.talent_bridge.TalentBridge.service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {
    private final JobApplicationService service;
    private final JobApplicationRepository jobApplicationRepository;
    public JobApplicationController(JobApplicationService service, JobApplicationRepository jobApplicationRepository) {
        this.service = service;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @PostMapping("/apply")
    public JobApplication applyForJob(@RequestBody JobApplicationDTO dto) {
        JobApplication jobApp = new JobApplication();

        // ✅ Ensure all fields (including jobId) are mapped
        jobApp.setJobId(dto.getJobId());
        jobApp.setApplicantName(dto.getApplicantName());
        jobApp.setApplicantEmail(dto.getApplicantEmail());
        jobApp.setCoverLetter(dto.getCoverLetter());
        jobApp.setResumePath(dto.getResumePath());
        jobApp.setAppliedAt(LocalDateTime.now());

        return jobApplicationRepository.save(jobApp);
    }
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<JobApplication>> getApplicationsForJob(@PathVariable Long jobId) {
        return ResponseEntity.ok(service.getApplicationsForJob(jobId));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<JobApplication>> getApplicationsForUser(@PathVariable String email) {
        return ResponseEntity.ok(service.getApplicationsForUser(email));
    }

    @GetMapping("/count")
    public long getApplicationCount(){
        return this.jobApplicationRepository.count();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationDTO> getApplicationById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getApplicationById(id));
    }

}
