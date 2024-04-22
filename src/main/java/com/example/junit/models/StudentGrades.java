package com.example.junit.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class StudentGrades {
    List<Double> mathGrades;

    public double addGrades(List<Double> grades){
        return grades.stream().mapToDouble(Double::doubleValue).sum();
    }

    public boolean isStudentPassed(int total){
        return total >= 200;
    }

    public String toString(){
        return mathGrades.toString();
    }
}
