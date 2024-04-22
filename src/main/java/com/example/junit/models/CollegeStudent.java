package com.example.junit.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CollegeStudent implements Student{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private StudentGrades studentGrades;

    @Override
    public String studentInformation() {
        return getFullName() + " " + getEmailAddress() + " " + studentGrades.getMathGrades();
    }

    @Override
    public String getFullName() {
        return getFirstName()+ " " + getLastName();
    }
}
