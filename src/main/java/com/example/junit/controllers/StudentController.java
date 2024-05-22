package com.example.junit.controllers;

import com.example.junit.entities.Student;
import com.example.junit.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Iterable<Student> getStudents(){
        return studentService.getStudents();
    }
}
