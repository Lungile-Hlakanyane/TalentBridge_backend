package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.InviteDTO;
import com.talent_bridge.TalentBridge.entity.Invite;
import com.talent_bridge.TalentBridge.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/invites")
public class InviteController {
    @Autowired
    private InviteService inviteService;

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
}
