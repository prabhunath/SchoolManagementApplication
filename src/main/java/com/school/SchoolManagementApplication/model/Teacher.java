package com.school.SchoolManagementApplication.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "teacher")
public class Teacher {

    String id;
    String staffId;
    String firstName;
    String lastName;
    int age;
    Subject subjects[];
    String address;

}
