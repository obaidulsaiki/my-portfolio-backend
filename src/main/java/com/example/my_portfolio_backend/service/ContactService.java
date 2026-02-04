package com.example.my_portfolio_backend.service;

import com.example.my_portfolio_backend.dto.ContactDTO;
import com.example.my_portfolio_backend.entity.ContactMessage;
import com.example.my_portfolio_backend.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String recipientEmail;

    public void saveMessage(ContactDTO contactDTO) {
        // 1. Save to Database
        ContactMessage message = ContactMessage.builder()
                .name(contactDTO.getName())
                .email(contactDTO.getEmail())
                .message(contactDTO.getMessage())
                .submittedAt(LocalDateTime.now())
                .build();
        contactRepository.save(message);

        // 2. Send Email Notification
        sendEmail(contactDTO);
    }

    private void sendEmail(ContactDTO contactDTO) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(recipientEmail);
            mailMessage.setSubject("New Contact Message from Portfolio: " + contactDTO.getName());
            mailMessage.setText(
                    "You have received a new message from your portfolio website.\n\n" +
                            "Name: " + contactDTO.getName() + "\n" +
                            "Email: " + contactDTO.getEmail() + "\n" +
                            "Message:\n" + contactDTO.getMessage());
            mailSender.send(mailMessage);
        } catch (Exception e) {
            // Log the error but don't fail the entire request
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}
