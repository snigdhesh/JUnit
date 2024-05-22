package com.example.junit.controllers;

import com.example.junit.entities.Student;
import com.example.junit.services.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @MockBean
    private StudentService studentService;

    @BeforeEach
    public void createTestRecord() {
        String query = "INSERT INTO STUDENT (ID, FIRSTNAME, LASTNAME, EMAIL) VALUES (1, 'ERIC', 'ROBY', 'ERIC@GMAIL.COM')";
        jdbcTemplate.execute(query);


        //Setup service response
        List<Student> students = new ArrayList<>();

        Student studentOne = new Student();
        studentOne.setId(1);
        studentOne.setFirstName("John");
        studentOne.setLastName("Doe");
        studentOne.setEmail("john@gmail.com");

        students.add(studentOne);

        Student studentTwo = new Student();
        studentTwo.setId(1);
        studentTwo.setFirstName("Jane");
        studentTwo.setLastName("Doe");
        studentTwo.setEmail("jane@gmail.com");

        students.add(studentTwo);
        when(studentService.getStudents()).thenReturn(students);
    }

    @AfterEach
    public void deleteTestRecords() {
        String query = "DELETE FROM STUDENT";
        jdbcTemplate.execute(query);
    }

    @Test
    public void getStudentsTest() throws Exception {
        RequestBuilder requestBuilder = get("/students");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andReturn();

    }


}
