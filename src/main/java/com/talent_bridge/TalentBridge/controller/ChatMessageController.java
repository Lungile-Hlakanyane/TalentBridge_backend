package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.ChatMessageDTO;
import com.talent_bridge.TalentBridge.service.ChatMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatMessageController {
    private final ChatMessageService chatService;

    public ChatMessageController(ChatMessageService chatService) {
        this.chatService = chatService;
    }
    @PostMapping("/send")
    public ResponseEntity<ChatMessageDTO> sendMessage(@RequestBody ChatMessageDTO dto) {
        return ResponseEntity.ok(chatService.sendMessage(dto));
    }
    @GetMapping("/history")
    public ResponseEntity<List<ChatMessageDTO>> getChatHistory(
            @RequestParam Long senderId,
            @RequestParam Long receiverId) {
        return ResponseEntity.ok(chatService.getChatHistory(senderId, receiverId));
    }
    @GetMapping("/unread/{receiverId}")
    public ResponseEntity<List<ChatMessageDTO>> getUnreadMessages(@PathVariable Long receiverId) {
        return ResponseEntity.ok(chatService.getUnreadMessages(receiverId));
    }
    @PutMapping("/read/{messageId}")
    public ResponseEntity<Void> markAsRead(@PathVariable Long messageId) {
        chatService.markAsRead(messageId);
        return ResponseEntity.ok().build();
    }
}
