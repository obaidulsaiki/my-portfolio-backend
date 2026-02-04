package com.example.my_portfolio_backend.service;

import com.example.my_portfolio_backend.dto.ContactDTO;
import com.example.my_portfolio_backend.entity.ContactMessage;
import com.example.my_portfolio_backend.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public void saveMessage(ContactDTO contactDTO) {
        ContactMessage message = ContactMessage.builder()
                .name(contactDTO.getName())
                .email(contactDTO.getEmail())
                .message(contactDTO.getMessage())
                .submittedAt(LocalDateTime.now())
                .build();
        contactRepository.save(message);
    }
}
