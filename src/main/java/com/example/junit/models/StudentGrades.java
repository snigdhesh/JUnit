package com.example.junit.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class StudentGrades {
    List<Double> mathGrades;

    public String toString(){
        return mathGrades.toString();
    }
}
