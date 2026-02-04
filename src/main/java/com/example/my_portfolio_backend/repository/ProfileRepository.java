package com.example.my_portfolio_backend.repository;

import com.example.my_portfolio_backend.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // We can add a method to find the main profile if needed
}
