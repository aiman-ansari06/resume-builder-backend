package com.resume.service;

import com.resume.model.Resume;
import com.resume.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    // Create Resume
    public Resume createResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    // Get All Resumes
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    // Get Resume by ID
    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id).orElse(null);
    }

    // Update Resume
    public Resume updateResume(Long id, Resume updatedResume) {
        Optional<Resume> existingResume = resumeRepository.findById(id);
        if (existingResume.isPresent()) {
            Resume resume = existingResume.get();
            resume.setName(updatedResume.getName());
            resume.setEmail(updatedResume.getEmail());
            resume.setPhone(updatedResume.getPhone());
            resume.setSkills(updatedResume.getSkills());
            resume.setExperience(updatedResume.getExperience());
            resume.setEducation(updatedResume.getEducation());
            return resumeRepository.save(resume);
        }
        return null;
    }

    // Delete Resume
    public boolean deleteResume(Long id) {
        if (resumeRepository.existsById(id)) {
            resumeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}