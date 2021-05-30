package com.school.SchoolManagementApplication.controller;

import com.school.SchoolManagementApplication.model.Subject;
import com.school.SchoolManagementApplication.repository.SubjectMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school/subjects")
public class SubjectRestController {

    @Autowired
    SubjectMongoRepository subjectMongoRepository;


    @GetMapping
    public ResponseEntity<?> getAllSubjects() {
        try {
            List<Subject> allSubjects = subjectMongoRepository.findAll();
            return new ResponseEntity<>(allSubjects, HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>("Exception while fetching subject(s)", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<?> addSubject(@RequestBody Subject subject) {
        try {
            subjectMongoRepository.save(subject);
            return new ResponseEntity<>("Subject added successfully.", HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>("Exception while adding subject", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping
    public ResponseEntity<?> deleteSubject(@RequestBody Subject subject) {
        try {
            subjectMongoRepository.delete(subject);
            return new ResponseEntity<>("Subject delete successfully.", HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>("Exception while deleting subject", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

