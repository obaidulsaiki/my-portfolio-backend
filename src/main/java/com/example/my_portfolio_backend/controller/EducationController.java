package com.example.my_portfolio_backend.controller;

import com.example.my_portfolio_backend.dto.EducationDTO;
import com.example.my_portfolio_backend.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @GetMapping
    public List<EducationDTO> getEducation() {
        return educationService.getEducationList();
    }
}
