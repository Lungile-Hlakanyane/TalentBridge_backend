package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.JobAlertSubscriptionDTO;
import com.talent_bridge.TalentBridge.service.JobAlertSubscriptionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class JobAlertSubscriptionController {
    private final JobAlertSubscriptionService service;
    public JobAlertSubscriptionController(JobAlertSubscriptionService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public JobAlertSubscriptionDTO createSubscription(@RequestBody JobAlertSubscriptionDTO dto) {
        return service.createSubscription(dto);
    }
    @GetMapping("/user/{userId}")
    public List<JobAlertSubscriptionDTO> getSubscriptionsByUser(@PathVariable Long userId) {
        return service.getSubscriptionsByUser(userId);
    }
    @GetMapping("/role/{jobRole}")
    public List<JobAlertSubscriptionDTO> getSubscriptionsByRole(@PathVariable String jobRole) {
        return service.getSubscriptionsByRole(jobRole);
    }
}
