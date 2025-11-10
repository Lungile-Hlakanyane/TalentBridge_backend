package com.talent_bridge.TalentBridge.service;
import com.talent_bridge.TalentBridge.DTO.InviteDTO;
import com.talent_bridge.TalentBridge.entity.Invite;
import java.util.List;

public interface InviteService {
    void sendInvite(InviteDTO inviteDTO);
    List<Invite> getInvitesForUser(Long receiverId);
    void updateInviteStatus(Long inviteId, String status);
    String getInviteStatus(Long senderId, Long receiverId);
}
