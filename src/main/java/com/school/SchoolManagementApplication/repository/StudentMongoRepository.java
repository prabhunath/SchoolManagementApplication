package com.school.SchoolManagementApplication.repository;

import com.school.SchoolManagementApplication.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentMongoRepository extends MongoRepository<Student, String> {
}
