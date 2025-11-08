package com.talent_bridge.TalentBridge.serviceImp;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendApplicationConfirmation(String to, String applicantName, String applicantEmail) {
        String subject = "Application Submitted Successfully";

        String body = String.format(
                "Dear %s,\n\n" +
                        "Your application was sent successfully.\n\n" +
                        "The following items were sent:\n" +
                        "1. CV\n" +
                        "2. Application (Name: %s, Email: %s, Cover Letter)\n\n" +
                        "Good Luck!\n\n" +
                        "Next step: The recruiter or job employer will reach out to you about your application.\n\n" +
                        "Best regards,\n" +
                        "TalentBridge Team",
                applicantName, applicantName, applicantEmail
        );
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    //Reusable method for general emails
    public void sendEmail(String email, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
