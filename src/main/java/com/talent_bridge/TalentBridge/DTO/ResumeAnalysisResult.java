package com.talent_bridge.TalentBridge.DTO;
import java.util.List;
import java.util.Map;

public class ResumeAnalysisResult {
    private String rawText;
    private List<String> emails;
    private List<String> phones;
    private List<String> skills;
    private Map<String, Integer> keywordCounts;

    // Getters and setters
    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Map<String, Integer> getKeywordCounts() {
        return keywordCounts;
    }

    public void setKeywordCounts(Map<String, Integer> keywordCounts) {
        this.keywordCounts = keywordCounts;
    }
}
