package com.example.junit.models;

import com.example.junit.services.Student;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("prototype")
public class CollegeStudent implements Student {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private StudentGrades grades;

    @Override
    public String studentInformation() {
        return getFullName() + " " + getEmailAddress() + " " + grades.getMathGrades();
    }

    @Override
    public String getFullName() {
        return getFirstName()+ " " + getLastName();
    }
}
