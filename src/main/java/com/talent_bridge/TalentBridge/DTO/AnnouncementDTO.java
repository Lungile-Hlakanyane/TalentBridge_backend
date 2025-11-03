package com.talent_bridge.TalentBridge.DTO;

import java.time.LocalDateTime;

public class AnnouncementDTO {
    private Long id;
    private String subject;
    private String context;
    private LocalDateTime dateAndTime;
    public AnnouncementDTO(){}

    public AnnouncementDTO(Long id, String subject, String context, LocalDateTime dateAndTime) {
        this.id = id;
        this.subject = subject;
        this.context = context;
        this.dateAndTime = dateAndTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
