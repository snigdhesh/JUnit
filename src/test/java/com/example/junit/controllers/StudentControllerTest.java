package com.example.junit.controllers;

import com.example.junit.entities.Student;
import com.example.junit.repositories.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void createTestRecord() {
        String query = "INSERT INTO STUDENT (ID,FIRSTNAME, LASTNAME, EMAIL) VALUES (100,'ERIC', 'ROBY', 'ERIC@GMAIL.COM')";
        jdbcTemplate.execute(query);
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
                .andExpect(jsonPath("$", hasSize(1))) //$ indicates root of JSON, so you can also use $.id, $.name etc where id, name are expected to be properties in json object.
                .andReturn();
    }

    @Test
    public void createStudentsTest() throws Exception {

        Student student = new Student();
        student.setFirstName("naga");
        student.setLastName("vadlapudi");
        student.setEmail("naga@gmail.com");

        RequestBuilder requestBuilder = post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student));

        this.mockMvc.perform(requestBuilder).andReturn();

        assertNotNull(studentRepository.findByEmail(student.getEmail()), "Student is available in database");

    }

    @Test
    public void deleteStudentTest() throws Exception {

        RequestBuilder requestBuilder = delete("/student/{id}", 100);

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                        .andExpect(content().string(""));

        assertFalse(studentRepository.findById(100).isPresent());

    }


}
