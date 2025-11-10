package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.InviteDTO;
import com.talent_bridge.TalentBridge.entity.Invite;
import com.talent_bridge.TalentBridge.repository.InviteRepository;
import com.talent_bridge.TalentBridge.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invites")
public class InviteController {
    @Autowired
    private InviteService inviteService;

    @Autowired
    private InviteRepository inviteRepository;

    @PostMapping("/send")
    public ResponseEntity<String> sendInvite(@RequestBody InviteDTO inviteDTO) {
        inviteService.sendInvite(inviteDTO);
        return ResponseEntity.ok("Invite saved successfully!");
    }

    @GetMapping("/user/{receiverId}")
    public ResponseEntity<List<Invite>> getUserInvites(@PathVariable Long receiverId) {
        return ResponseEntity.ok(inviteService.getInvitesForUser(receiverId));
    }

    @PutMapping("/{inviteId}/status")
    public ResponseEntity<String> updateInviteStatus(
            @PathVariable Long inviteId,
            @RequestParam String status
    ) {
        inviteService.updateInviteStatus(inviteId, status);
        return ResponseEntity.ok("Invite status updated to " + status);
    }

    @GetMapping("/status")
    public ResponseEntity<String> getInviteStatus(
            @RequestParam Long senderId,
            @RequestParam Long receiverId) {
        return inviteRepository.findBySenderIdAndReceiverId(senderId, receiverId)
                .map(invite -> ResponseEntity.ok(invite.getStatus()))
                .orElse(ResponseEntity.ok("NONE"));
    }

}
