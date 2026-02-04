package com.example.my_portfolio_backend.repository;

import com.example.my_portfolio_backend.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
