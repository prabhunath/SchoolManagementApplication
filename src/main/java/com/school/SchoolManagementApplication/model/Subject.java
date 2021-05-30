package com.school.SchoolManagementApplication.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "subject")
public class Subject {

    @Id
    String id;
    String subjectCode;
    String name;

}
