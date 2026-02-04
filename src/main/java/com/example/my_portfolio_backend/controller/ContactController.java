package com.example.my_portfolio_backend.controller;

import com.example.my_portfolio_backend.dto.ContactDTO;
import com.example.my_portfolio_backend.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:3000", "https://*.vercel.app", "https://obaidulsaiki.up.railway.app" })
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<String> submitContact(@RequestBody ContactDTO contactDTO) {
        try {
            contactService.saveMessage(contactDTO);
            return ResponseEntity.ok("Message sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send message: " + e.getMessage());
        }
    }
}
