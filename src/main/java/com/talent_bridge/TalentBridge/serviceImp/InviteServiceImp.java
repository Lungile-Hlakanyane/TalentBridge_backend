package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.InviteDTO;
import com.talent_bridge.TalentBridge.entity.Invite;
import com.talent_bridge.TalentBridge.repository.InviteRepository;
import com.talent_bridge.TalentBridge.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InviteServiceImp implements InviteService {

    @Autowired
    private InviteRepository inviteRepository;
    @Override
    public void sendInvite(InviteDTO inviteDTO) {
        Invite invite = new Invite();
        invite.setSenderId(inviteDTO.getSenderId());
        invite.setReceiverId(inviteDTO.getReceiverId());
        invite.setMessage(inviteDTO.getMessage());
        invite.setSentDate(LocalDateTime.now());
        invite.setStatus("PENDING");
        inviteRepository.save(invite);
    }
    @Override
    public List<Invite> getInvitesForUser(Long receiverId) {
        return inviteRepository.findByReceiverId(receiverId);
    }
    @Override
    public void updateInviteStatus(Long inviteId, String status) {
        Invite invite = inviteRepository.findById(inviteId).orElseThrow();
        invite.setStatus(status);
        inviteRepository.save(invite);
    }
}
