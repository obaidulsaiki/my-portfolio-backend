package com.example.my_portfolio_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDTO {
    private String institution;
    private String degree;
    private String subject;
    private String startDate;
    private String endDate;
    private List<String> activities;
    private List<String> clubs;
    private String certificateUrl;
}
