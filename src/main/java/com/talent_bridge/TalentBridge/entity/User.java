package com.talent_bridge.TalentBridge.entity;
import com.talent_bridge.TalentBridge.enums.Role;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Table( name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resumePath;
    private String name;
    private String surname;
    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    private String address;
    @Column(name = "reset_code")
    private String resetCode;
    @Column(nullable = false)
    private Boolean online = false;
    @Column(name = "reset_code_expiry")
    private LocalDateTime resetCodeExpiry;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;
    private boolean activated = false;
    private String activationToken;
    private LocalDateTime tokenExpiry;
    private String companyName;

    public User() {
    }

    public User(Long id, String resumePath, String name, String surname,
                String companyName, String email, String phone, String address,
                Role role, String password, boolean activated, String activationToken,
                LocalDateTime tokenExpiry,
                String resetCode,
                LocalDateTime resetCodeExpiry,
                Boolean online
                ) {
        this.id = id;
        this.resumePath = resumePath;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.password = password;
        this.activated = activated;
        this.activationToken = activationToken;
        this.tokenExpiry = tokenExpiry;
        this.companyName = companyName;
        this.resetCode = resetCode;
        this.resetCodeExpiry = resetCodeExpiry;
        this.online = online;
    }

    public boolean isOnline() {
        return online;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getResetCode() {
        return resetCode;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    public LocalDateTime getResetCodeExpiry() {
        return resetCodeExpiry;
    }

    public void setResetCodeExpiry(LocalDateTime resetCodeExpiry) {
        this.resetCodeExpiry = resetCodeExpiry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResumePath() {
        return resumePath;
    }
    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isActivated() {
        return activated;
    }
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    public String getActivationToken() {
        return activationToken;
    }
    public void setActivationToken(String activationToken) {
        this.activationToken = activationToken;
    }
    public LocalDateTime getTokenExpiry() {
        return tokenExpiry;
    }
    public void setTokenExpiry(LocalDateTime tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }
}
