package com.example.junit;

import com.example.junit.models.CollegeStudent;
import com.example.junit.models.StudentGrades;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootTest
class JUnitApplicationTests {
    private int count = 0;

    @Value("${info.app.name}")
    private String appInfo;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades studentGrades;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    public void beforeEach(){
        count++;
        System.out.println("Testing "+ appInfo+":"+appVersion);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmailAddress("johndoe@gmail.com");
        studentGrades.setMathGrades(Arrays.asList(90.0, 80.0, 70.0, 60.0, 50.0));
        student.setGrades(studentGrades);
    }
    @Test
    @DisplayName("Add grade results for student grades")
    void addGrades() {
        assertEquals(350.0,studentGrades.addGrades(student.getGrades().getMathGrades()));
    }

    @Test
    @DisplayName("Add grade results for student grades not equal")
    void addGradeResultsNotEqual() {
        assertNotEquals(450.0,studentGrades.addGrades(student.getGrades().getMathGrades()));
    }


    @DisplayName("Is student passed")
    @Test
    void isStudentPassed() {
        assertTrue(studentGrades.isStudentPassed(350));
    }

    @DisplayName("Is student failed")
    @Test
    void isStudentFailed() {
        assertFalse(studentGrades.isStudentPassed(150));
    }


    @DisplayName("Student with no grades")
    @Test
    void studentWithNoGrades() {
        CollegeStudent studentTwo = context.getBean(CollegeStudent.class);
        studentTwo.setFirstName("Jane");
        studentTwo.setLastName("Doe");
        studentTwo.setEmailAddress("janedoe@gmail.com");
        assertNotNull(studentTwo);
        assertNull(studentTwo.getGrades());
    }

    @DisplayName("Both students are not the same")
    @Test
    void verifyStudents() {
        CollegeStudent studentTwo = context.getBean(CollegeStudent.class);
        assertNotSame(student, studentTwo);
    }

}
