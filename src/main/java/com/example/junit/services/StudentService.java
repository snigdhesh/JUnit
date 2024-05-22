package com.example.junit.services;

import com.example.junit.entities.Student;
import com.example.junit.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<String> getGrades() {
        return Arrays.asList("math", "science");
    }

    public boolean isStudentNull(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) return true;
        return false;
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
