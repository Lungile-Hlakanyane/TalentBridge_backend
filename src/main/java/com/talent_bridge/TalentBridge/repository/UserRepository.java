package com.talent_bridge.TalentBridge.repository;
import com.talent_bridge.TalentBridge.entity.User;
import com.talent_bridge.TalentBridge.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByActivationToken(String token);
    long countByRole(Role role);
    List<User> findByRole(Role role);
}
