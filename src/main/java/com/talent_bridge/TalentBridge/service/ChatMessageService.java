package com.talent_bridge.TalentBridge.service;
import com.talent_bridge.TalentBridge.DTO.ChatMessageDTO;
import java.util.List;

public interface ChatMessageService {
    ChatMessageDTO sendMessage(ChatMessageDTO messageDTO);
    List<ChatMessageDTO> getChatHistory(Long senderId, Long receiverId);
    List<ChatMessageDTO> getUnreadMessages(Long receiverId);
    void markAsRead(Long messageId);
}
