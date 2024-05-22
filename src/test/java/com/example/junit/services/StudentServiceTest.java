package com.example.junit.services;


import com.example.junit.entities.Student;
import com.example.junit.repositories.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void createTestRecord(){
        String query = "INSERT INTO STUDENT (ID, FIRSTNAME, LASTNAME, EMAIL) VALUES (1, 'ERIC', 'ROBY', 'ERIC@GMAIL.COM')";
        jdbcTemplate.execute(query);
    }

    @Test
    public void deleteStudentTest(){
        Optional<Student> student = studentRepository.findById(1);
        assertTrue(student.isPresent(), "Student is present");
        studentService.deleteStudent(1);
        student = studentRepository.findById(1);
        assertFalse(student.isPresent(), "Student is deleted");
    }

    @Test
    public void studentNullCheck(){
        assertTrue(studentService.isStudentNull(1));
        assertFalse(studentService.isStudentNull(34));
    }

    @Test
    public void getAllStudentsFromDBTest(){
        Iterable<Student> students = studentService.getStudents();
        List<Student> studentList = new ArrayList<>();
        students.forEach(student -> studentList.add(student));
        assertEquals(1, studentList.size());
    }

    @AfterEach
    public void deleteTestRecords(){
        String query = "DELETE FROM STUDENT";
        jdbcTemplate.execute(query);
    }
}
