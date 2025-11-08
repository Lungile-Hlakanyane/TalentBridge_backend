package com.talent_bridge.TalentBridge.repository;
import com.talent_bridge.TalentBridge.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySenderIdAndReceiverIdOrReceiverIdAndSenderId(
            Long senderId, Long receiverId, Long receiverId2, Long senderId2
    );
    List<ChatMessage> findByReceiverIdAndReadStatusFalse(Long receiverId);
}
