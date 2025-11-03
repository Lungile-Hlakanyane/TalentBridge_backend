package com.talent_bridge.TalentBridge.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "job_alert_subscriptions")
public class JobAlertSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String email;
    private String jobRole;
    public JobAlertSubscription() {}
    public JobAlertSubscription(Long userId, String email, String jobRole) {
        this.userId = userId;
        this.email = email;
        this.jobRole = jobRole;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getJobRole() { return jobRole; }
    public void setJobRole(String jobRole) { this.jobRole = jobRole; }
}
