package com.talent_bridge.TalentBridge.mapper;
import com.talent_bridge.TalentBridge.DTO.ChatMessageDTO;
import com.talent_bridge.TalentBridge.entity.ChatMessage;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageMapper {
    public ChatMessageDTO toDTO(ChatMessage entity) {
        ChatMessageDTO dto = new ChatMessageDTO();
        dto.setId(entity.getId());
        dto.setSenderId(entity.getSenderId());
        dto.setReceiverId(entity.getReceiverId());
        dto.setMessage(entity.getMessage());
        dto.setTimestamp(entity.getTimestamp());
        dto.setReadStatus(entity.isReadStatus());
        return dto;
    }
    public ChatMessage toEntity(ChatMessageDTO dto) {
        ChatMessage entity = new ChatMessage();
        entity.setId(dto.getId());
        entity.setSenderId(dto.getSenderId());
        entity.setReceiverId(dto.getReceiverId());
        entity.setMessage(dto.getMessage());
        entity.setTimestamp(dto.getTimestamp());
        entity.setReadStatus(dto.isReadStatus());
        return entity;
    }
}
