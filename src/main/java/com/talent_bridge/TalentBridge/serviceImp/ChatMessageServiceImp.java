package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.ChatMessageDTO;
import com.talent_bridge.TalentBridge.entity.ChatMessage;
import com.talent_bridge.TalentBridge.mapper.ChatMessageMapper;
import com.talent_bridge.TalentBridge.repository.ChatMessageRepository;
import com.talent_bridge.TalentBridge.service.ChatMessageService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatMessageServiceImp implements ChatMessageService {
    private final ChatMessageRepository chatRepo;
    private final ChatMessageMapper mapper;

    public ChatMessageServiceImp(ChatMessageRepository chatRepo, ChatMessageMapper mapper) {
        this.chatRepo = chatRepo;
        this.mapper = mapper;
    }

    @Override
    public ChatMessageDTO sendMessage(ChatMessageDTO messageDTO) {
        ChatMessage message = mapper.toEntity(messageDTO);
        message.setTimestamp(LocalDateTime.now());
        ChatMessage saved = chatRepo.save(message);
        return mapper.toDTO(saved);
    }

    @Override
    public List<ChatMessageDTO> getChatHistory(Long senderId, Long receiverId) {
        return chatRepo
                .findBySenderIdAndReceiverIdOrReceiverIdAndSenderId(senderId, receiverId, senderId, receiverId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChatMessageDTO> getUnreadMessages(Long receiverId) {
        return chatRepo.findByReceiverIdAndReadStatusFalse(receiverId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void markAsRead(Long messageId) {
        chatRepo.findById(messageId).ifPresent(message -> {
            message.setReadStatus(true);
            chatRepo.save(message);
        });
    }
}
