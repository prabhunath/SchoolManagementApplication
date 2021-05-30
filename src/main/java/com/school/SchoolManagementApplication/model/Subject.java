package com.school.SchoolManagementApplication.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "subject")
public class Subject {

    String id;
    String subjectId;
    String name;
    String publication;
    int yearOfPublication;
    String author;
}
