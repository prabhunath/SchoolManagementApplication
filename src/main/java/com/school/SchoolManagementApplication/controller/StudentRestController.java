package com.school.SchoolManagementApplication.controller;

import com.school.SchoolManagementApplication.model.Student;
import com.school.SchoolManagementApplication.repository.StudentMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school/students")
public class StudentRestController {

    @Autowired
    StudentMongoRepository studentMongoRepository;


    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        try {
            List<Student> allStudents = studentMongoRepository.findAll();
            return new ResponseEntity<>(allStudents, HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>("Exception while fetching students", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        try {
            studentMongoRepository.save(student);
            return new ResponseEntity<>("Student added successfully.", HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>("Exception while adding student", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@RequestBody Student student) {
        try {
            studentMongoRepository.delete(student);
            return new ResponseEntity<>("Student delete successfully.", HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>("Exception while deleting student", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
