package com.example.demo;

import com.example.demo.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    // CRUD provided automatically
}
