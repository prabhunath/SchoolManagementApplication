package com.school.SchoolManagementApplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "student")
public class Student {

    @Id
    String id;
    Long rollNumber;
    String firstName;
    String lastName;
    String classStd;
    Subject subjects[];
    String address;

}
