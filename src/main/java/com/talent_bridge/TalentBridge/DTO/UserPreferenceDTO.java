package com.talent_bridge.TalentBridge.DTO;
import java.util.ArrayList;
import java.util.List;

public class UserPreferenceDTO {
    private Long id;
    private String userId;
    private List<String> industries = new ArrayList<>();
    private List<String> jobTypes = new ArrayList<>();
    private List<String> experienceLevels = new ArrayList<>();
    public UserPreferenceDTO() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public List<String> getIndustries() { return industries; }
    public void setIndustries(List<String> industries) { this.industries = industries; }
    public List<String> getJobTypes() { return jobTypes; }
    public void setJobTypes(List<String> jobTypes) { this.jobTypes = jobTypes; }
    public List<String> getExperienceLevels() { return experienceLevels; }
    public void setExperienceLevels(List<String> experienceLevels) { this.experienceLevels = experienceLevels; }
}
