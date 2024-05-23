package com.example.junit.controllers;

import com.example.junit.entities.Student;
import com.example.junit.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Iterable<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public Student createStudents(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void createStudents(@PathVariable int id){
        studentService.deleteStudent(id);
    }
}
