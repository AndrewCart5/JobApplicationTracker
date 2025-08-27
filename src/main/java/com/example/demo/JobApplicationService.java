package com.example.demo;

import com.example.demo.JobApplication;
import com.example.demo.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repo;

    public JobApplicationService(JobApplicationRepository repo) {
        this.repo = repo;
    }

    public List<JobApplication> getAll() {
        return repo.findAll();
    }

    public JobApplication getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public JobApplication create(JobApplication app) {
        return repo.save(app);
    }

    public JobApplication update(Long id, JobApplication updated) {
        JobApplication existing = getById(id);
        existing.setCompany(updated.getCompany());
        existing.setPosition(updated.getPosition());
        existing.setStatus(updated.getStatus());
        existing.setDateApplied(updated.getDateApplied());
        existing.setNotes(updated.getNotes());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
