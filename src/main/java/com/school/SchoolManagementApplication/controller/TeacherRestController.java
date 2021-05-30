package com.school.SchoolManagementApplication.controller;

import com.school.SchoolManagementApplication.model.Teacher;
import com.school.SchoolManagementApplication.repository.TeacherMongoRespository;
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
@RequestMapping("/school/teachers")
public class TeacherRestController {

    @Autowired
    TeacherMongoRespository teacherMongoRespository;


    @GetMapping
    public ResponseEntity<?> getAllTeachers() {
        try {
            List<Teacher> allTeachers = teacherMongoRespository.findAll();
            return new ResponseEntity<>(allTeachers, HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>("Exception while fetching teacher(s)", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<?> addSubject(@RequestBody Teacher teacher) {
        try {
            teacherMongoRespository.save(teacher);
            return new ResponseEntity<>("Teacher added successfully.", HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>("Exception while adding teacher", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping
    public ResponseEntity<?> deleteSubject(@RequestBody Teacher teacher) {
        try {
            teacherMongoRespository.delete(teacher);
            return new ResponseEntity<>("Teacher delete successfully.", HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>("Exception while deleting teacher", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
