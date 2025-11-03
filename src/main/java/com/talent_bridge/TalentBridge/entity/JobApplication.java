package com.talent_bridge.TalentBridge.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long jobId;
    private String applicantName;
    private String applicantEmail;
    @Column(length = 2000)
    private String coverLetter;
    private String resumePath;
    private LocalDateTime appliedAt;
    public JobApplication() {}
    public JobApplication(Long jobId, String applicantName, String applicantEmail, String coverLetter, String resumePath, LocalDateTime appliedAt) {
        this.jobId = jobId;
        this.applicantName = applicantName;
        this.applicantEmail = applicantEmail;
        this.coverLetter = coverLetter;
        this.resumePath = resumePath;
        this.appliedAt = appliedAt;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }
    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }
    public String getApplicantEmail() { return applicantEmail; }
    public void setApplicantEmail(String applicantEmail) { this.applicantEmail = applicantEmail; }
    public String getCoverLetter() { return coverLetter; }
    public void setCoverLetter(String coverLetter) { this.coverLetter = coverLetter; }
    public String getResumePath() { return resumePath; }
    public void setResumePath(String resumePath) { this.resumePath = resumePath; }
    public LocalDateTime getAppliedAt() { return appliedAt; }
    public void setAppliedAt(LocalDateTime appliedAt) { this.appliedAt = appliedAt; }
}
