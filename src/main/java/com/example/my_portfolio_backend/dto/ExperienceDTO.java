package com.example.my_portfolio_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDTO {
    private String company;
    private String role;
    private String location;
    private String startDate;
    private String endDate;
    private List<String> description;
    private List<String> technologies;
}
