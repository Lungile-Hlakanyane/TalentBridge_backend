package com.talent_bridge.TalentBridge.repository;
import com.talent_bridge.TalentBridge.entity.Invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InviteRepository extends JpaRepository<Invite, Long> {
    List<Invite> findByReceiverId(Long receiverId);
}
