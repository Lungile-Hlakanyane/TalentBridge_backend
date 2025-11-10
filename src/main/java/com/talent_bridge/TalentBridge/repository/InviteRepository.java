package com.talent_bridge.TalentBridge.repository;
import com.talent_bridge.TalentBridge.entity.Invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InviteRepository extends JpaRepository<Invite, Long> {
    List<Invite> findByReceiverId(Long receiverId);
    @Query("SELECT i.status FROM Invite i WHERE i.senderId = :senderId AND i.receiverId = :receiverId")
    Optional<String> findInviteStatus(@Param("senderId") Long senderId, @Param("receiverId") Long receiverId);
    Optional<Invite> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
