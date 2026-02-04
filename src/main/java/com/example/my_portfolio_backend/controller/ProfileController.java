package com.example.my_portfolio_backend.controller;

import com.example.my_portfolio_backend.dto.ProfileDTO;
import com.example.my_portfolio_backend.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public ProfileDTO getProfile() {
        return profileService.getProfile();
    }
}
