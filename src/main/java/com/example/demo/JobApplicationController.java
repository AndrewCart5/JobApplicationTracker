package com.example.demo;

import com.example.demo.JobApplication;
import com.example.demo.JobApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*") // allows frontend calls
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<JobApplication> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public JobApplication getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public JobApplication create(@RequestBody JobApplication app) {
        return service.create(app);
    }

    @PutMapping("/{id}")
    public JobApplication update(@PathVariable Long id, @RequestBody JobApplication updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
