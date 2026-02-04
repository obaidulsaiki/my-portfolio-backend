package com.example.my_portfolio_backend.service;

import com.example.my_portfolio_backend.dto.EducationDTO;
import com.example.my_portfolio_backend.entity.Education;
import com.example.my_portfolio_backend.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;

    public List<EducationDTO> getEducationList() {
        List<Education> educationList = educationRepository.findAll();
        if (educationList.isEmpty()) {
            // Seeding default data for demo/fallback
            return Arrays.asList(
                    new EducationDTO(
                            "Your University Name",
                            "Bachelor of Science",
                            "Computer Science & Engineering",
                            "2020",
                            "2024",
                            Arrays.asList("Dean's List Award", "Research Assistant in AI Lab",
                                    "Technical Lead for Annual Fest"),
                            Arrays.asList("Programming Club", "IEEE Student Branch"),
                            "https://drive.google.com/your-cert-link"));
        }
        return educationList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private EducationDTO mapToDTO(Education education) {
        return new EducationDTO(
                education.getInstitution(),
                education.getDegree(),
                education.getSubject(),
                education.getStartDate().toString(),
                education.getEndDate().toString(),
                education.getActivities(),
                education.getClubs(),
                education.getCertificateUrl());
    }
}
