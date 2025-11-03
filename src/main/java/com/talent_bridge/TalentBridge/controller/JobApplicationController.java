package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.JobApplicationDTO;
import com.talent_bridge.TalentBridge.entity.JobApplication;
import com.talent_bridge.TalentBridge.repository.JobApplicationRepository;
import com.talent_bridge.TalentBridge.service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<JobApplication> applyForJob(@RequestBody JobApplicationDTO dto) {
        JobApplication saved = service.applyForJob(dto);
        return ResponseEntity.ok(saved);
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
}
