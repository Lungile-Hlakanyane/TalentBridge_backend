package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.JobDTO;
import com.talent_bridge.TalentBridge.repository.JobRepository;
import com.talent_bridge.TalentBridge.service.JobService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;
    private final JobRepository jobRepository;

    public JobController(JobService jobService, JobRepository jobRepository) {
        this.jobService = jobService;
        this.jobRepository = jobRepository;
    }

    @PostMapping("/create")
    public JobDTO createJob(@RequestBody JobDTO jobDTO) {
        return jobService.createJob(jobDTO);
    }

    @GetMapping("/{id}")
    public JobDTO getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @GetMapping
    public List<JobDTO> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/user/{userId}")
    public List<JobDTO> getJobsByUserId(@PathVariable Long userId) {
        return jobService.getJobsByUserId(userId);
    }

    @PutMapping("/{id}")
    public JobDTO updateJob(@PathVariable Long id, @RequestBody JobDTO jobDTO) {
        return jobService.updateJob(id, jobDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }

    @PutMapping("/{id}/approve")
    public JobDTO approveJob(@PathVariable Long id) {
        return jobService.changeApprovalStatus(id, true, "approved");
    }

    @PutMapping("/{id}/decline")
    public JobDTO declineJob(@PathVariable Long id) {
        return jobService.changeApprovalStatus(id, false, "declined");
    }

    @GetMapping("/count")
    public long getJobCount(){
        return jobRepository.count();
    }

}
