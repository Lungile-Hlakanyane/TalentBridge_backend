package com.talent_bridge.TalentBridge.DTO;

public class JobAlertSubscriptionDTO {
    private Long userId;
    private String email;
    private String jobRole;
    public JobAlertSubscriptionDTO() {}
    public JobAlertSubscriptionDTO(Long userId, String email, String jobRole) {
        this.userId = userId;
        this.email = email;
        this.jobRole = jobRole;
    }
    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getJobRole() { return jobRole; }
    public void setJobRole(String jobRole) { this.jobRole = jobRole; }
}
