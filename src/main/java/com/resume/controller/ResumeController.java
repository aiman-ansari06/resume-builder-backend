package com.resume.controller;

import com.resume.model.Resume;
import com.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    // Create Resume
    @PostMapping("/create")
    public ResponseEntity<Resume> createResume(@RequestBody Resume resume) {
        return ResponseEntity.ok(resumeService.createResume(resume));
    }

    // Get All Resumes
    @GetMapping("/all")
    public ResponseEntity<List<Resume>> getAllResumes() {
        return ResponseEntity.ok(resumeService.getAllResumes());
    }

    // Get Resume by ID
    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long id) {
        return ResponseEntity.ok(resumeService.getResumeById(id));
    }

    // Update Resume
    @PutMapping("/update/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable Long id, @RequestBody Resume resume) {
        return ResponseEntity.ok(resumeService.updateResume(id, resume));
    }

    // Delete Resume
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteResume(@PathVariable Long id) {
        boolean deleted = resumeService.deleteResume(id);
        if (deleted) {
            return ResponseEntity.ok("Resume deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Resume not found.");
        }
    }
}