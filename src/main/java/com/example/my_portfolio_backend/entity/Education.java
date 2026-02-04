package com.example.my_portfolio_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "education")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String institution;
    private String degree;
    private String subject;
    private LocalDate startDate;
    private LocalDate endDate;

    @ElementCollection
    private List<String> activities;

    @ElementCollection
    private List<String> clubs;

    private String certificateUrl;
}
