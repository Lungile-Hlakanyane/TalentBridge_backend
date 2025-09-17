package com.talent_bridge.TalentBridge.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "user_preferences")
public class UserPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userId;
    @ElementCollection
    @CollectionTable(name = "preference_industries", joinColumns = @JoinColumn(name = "preference_id"))
    @Column(name = "industry")
    private List<String> industries = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "preference_job_types", joinColumns = @JoinColumn(name = "preference_id"))
    @Column(name = "job_type")
    private List<String> jobTypes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "preference_experience", joinColumns = @JoinColumn(name = "preference_id"))
    @Column(name = "experience_level")
    private List<String> experienceLevels = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public UserPreference() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getIndustries() {
        return industries;
    }

    public void setIndustries(List<String> industries) {
        this.industries = industries;
    }

    public List<String> getJobTypes() {
        return jobTypes;
    }

    public void setJobTypes(List<String> jobTypes) {
        this.jobTypes = jobTypes;
    }

    public List<String> getExperienceLevels() {
        return experienceLevels;
    }

    public void setExperienceLevels(List<String> experienceLevels) {
        this.experienceLevels = experienceLevels;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
