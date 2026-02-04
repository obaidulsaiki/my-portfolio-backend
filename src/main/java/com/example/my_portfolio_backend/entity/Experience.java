package com.example.my_portfolio_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "experience")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String role;
    private String location;
    private String startDate;
    private String endDate;

    @ElementCollection
    private List<String> description;

    @ElementCollection
    private List<String> technologies;
}
