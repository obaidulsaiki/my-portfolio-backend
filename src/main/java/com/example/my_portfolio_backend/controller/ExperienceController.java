package com.example.my_portfolio_backend.controller;

import com.example.my_portfolio_backend.dto.ExperienceDTO;
import com.example.my_portfolio_backend.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @GetMapping
    public List<ExperienceDTO> getExperience() {
        return experienceService.getExperienceList();
    }
}
