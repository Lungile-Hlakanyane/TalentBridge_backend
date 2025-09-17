package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.LoginDTO;
import com.talent_bridge.TalentBridge.DTO.UserDTO;
import com.talent_bridge.TalentBridge.entity.User;
import com.talent_bridge.TalentBridge.mapper.UserMapper;
import com.talent_bridge.TalentBridge.repository.UserRepository;
import com.talent_bridge.TalentBridge.service.UserService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final JavaMailSender mailSender;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public UserServiceImp(UserRepository userRepository, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    @Override
    public void createUser(UserDTO dto) {
        String token = UUID.randomUUID().toString();
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        String resumePath = String.valueOf(dto.getResume());
        User user = UserMapper.toEntity(dto, resumePath, hashedPassword, token);
        user.setTokenExpiry(LocalDateTime.now().plusHours(24));
        userRepository.save(user);
        sendActivationEmail(dto.getEmail(), token);
    }

    @Override
    public boolean activateAccount(String token) {
        return userRepository.findByActivationToken(token)
                .map(user -> {
                    if (user.getTokenExpiry().isBefore(LocalDateTime.now())) {
                        throw new RuntimeException("Activation token expired");
                    }
                    user.setActivated(true);
                    user.setActivationToken(null);
                    userRepository.save(user);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public User login(LoginDTO loginDTO) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmail(loginDTO.getEmail());
        if (!optionalUser.isPresent()) {
            throw new Exception("Invalid email or password");
        }
        User user = optionalUser.get();
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new Exception("Invalid email or password");
        }
        if (!user.isActivated()) {
            throw new Exception("Account not activated. Please check your email.");
        }
        return user;
    }


    private void sendActivationEmail(String email, String token) {
        String activationLink = "http://localhost:8080/api/users/activate?token=" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("TalentBridge Account Activation");
        message.setText("Welcome to TalentBridge!\n\nPlease click the link below to activate your account:\n"
                + activationLink + "\n\nThis link expires in 24 hours.");
        mailSender.send(message);
    }
}
