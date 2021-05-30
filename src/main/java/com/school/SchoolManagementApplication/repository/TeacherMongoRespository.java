package com.school.SchoolManagementApplication.repository;

import com.school.SchoolManagementApplication.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherMongoRespository extends MongoRepository<Teacher, String> {
}
