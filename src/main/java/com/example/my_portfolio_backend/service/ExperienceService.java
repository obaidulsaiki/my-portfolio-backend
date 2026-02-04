package com.example.my_portfolio_backend.service;

import com.example.my_portfolio_backend.dto.ExperienceDTO;
import com.example.my_portfolio_backend.entity.Experience;
import com.example.my_portfolio_backend.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public List<ExperienceDTO> getExperienceList() {
        List<Experience> experienceList = experienceRepository.findAll();
        if (experienceList.isEmpty()) {
            return Arrays.asList(
                    new ExperienceDTO(
                            "Software Engineering Intern",
                            "Tech Solutions Inc.",
                            "Dhaka, Bangladesh",
                            "June 2023",
                            "August 2023",
                            Arrays.asList(
                                    "Assisted in developing REST APIs using Spring Boot and PostgreSQL.",
                                    "Optimized database queries, reducing response time by 15%.",
                                    "Collaborated with the frontend team to integrate Auth0 authentication."),
                            Arrays.asList("Spring Boot", "PostgreSQL", "React", "Docker")));
        }
        return experienceList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private ExperienceDTO mapToDTO(Experience experience) {
        return new ExperienceDTO(
                experience.getCompany(),
                experience.getRole(),
                experience.getLocation(),
                experience.getStartDate(),
                experience.getEndDate(),
                experience.getDescription(),
                experience.getTechnologies());
    }
}
