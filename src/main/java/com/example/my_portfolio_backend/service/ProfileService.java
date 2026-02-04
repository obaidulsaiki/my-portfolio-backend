package com.example.my_portfolio_backend.service;

import com.example.my_portfolio_backend.dto.ProfileDTO;
import com.example.my_portfolio_backend.entity.Profile;
import com.example.my_portfolio_backend.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileDTO getProfile() {
        return profileRepository.findAll().stream()
                .findFirst()
                .map(this::mapToDTO)
                .orElse(new ProfileDTO(
                        "Obaidul Haque", 
                        "Java Backend Developer & Researcher", 
                        "I am passionate about developing robust applications with Java Spring Boot, while simultaneously pursuing innovative research to bridge the gap between academic theory and industry-scale implementation.", 
                        "/images/profile.png", 
                        "contact@example.com"
                ));
    }

    private ProfileDTO mapToDTO(Profile profile) {
        return new ProfileDTO(
                profile.getName(),
                profile.getTitle(),
                profile.getBio(),
                profile.getImageUrl(),
                profile.getContactEmail());
    }
}
