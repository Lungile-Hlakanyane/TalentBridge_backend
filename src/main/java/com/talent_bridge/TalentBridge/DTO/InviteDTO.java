package com.talent_bridge.TalentBridge.DTO;

public class InviteDTO {
    private Long senderId;
    private Long receiverId;
    private String message;

    public Long getSenderId() { return senderId; }
    public void setSenderId(Long senderId) { this.senderId = senderId; }

    public Long getReceiverId() { return receiverId; }
    public void setReceiverId(Long receiverId) { this.receiverId = receiverId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
