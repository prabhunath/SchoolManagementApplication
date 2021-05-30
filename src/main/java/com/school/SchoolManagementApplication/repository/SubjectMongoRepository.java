package com.school.SchoolManagementApplication.repository;

import com.school.SchoolManagementApplication.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectMongoRepository extends MongoRepository<Subject, String> {
}
