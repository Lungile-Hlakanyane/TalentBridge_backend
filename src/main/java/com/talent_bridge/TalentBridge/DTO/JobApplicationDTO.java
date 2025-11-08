package com.talent_bridge.TalentBridge.DTO;

public class JobApplicationDTO {
    private Long jobId;
    private String applicantName;
    private String applicantEmail;
    private String coverLetter;
    private String resumePath;
    private String jobTitle;
    private String companyName;

    public JobApplicationDTO() {
    }

    // Optional convenience constructor
    public JobApplicationDTO(Long jobId, String applicantName, String applicantEmail, String coverLetter, String resumePath) {
        this.jobId = jobId;
        this.applicantName = applicantName;
        this.applicantEmail = applicantEmail;
        this.coverLetter = coverLetter;
        this.resumePath = resumePath;
    }

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

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
}
