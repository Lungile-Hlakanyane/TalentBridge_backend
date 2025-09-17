package com.talent_bridge.TalentBridge.DTO;
import java.time.LocalDateTime;

public class JobDTO {

    private Long id;
    private String title;
    private String company;
    private String location;
    private String type;
    private String salary;
    private String description;
    private Long userId;
    private LocalDateTime created;
    public JobDTO() {}

    public JobDTO(Long id, String title, String company, String location, String type, String salary, String description, Long userId, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.type = type;
        this.salary = salary;
        this.description = description;
        this.userId = userId;
        this.created = created;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getSalary() { return salary; }
    public void setSalary(String salary) { this.salary = salary; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public LocalDateTime getCreated() {return created;}
    public void setCreated(LocalDateTime created) {this.created = created;}
}
