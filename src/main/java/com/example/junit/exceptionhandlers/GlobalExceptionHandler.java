package com.example.junit.exceptionhandlers;

import com.example.junit.exceptions.StudentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {StudentNotFoundException.class})
    public void handleStudentNotFoundException(StudentNotFoundException ex){
        logError(ex);
    }

    @ExceptionHandler(value = {Exception.class})
    public void handleUncaughtException(Exception ex){
        logError(ex);
    }

    private void logError(Exception ex){
        log.error("EXCEPTION={}||EXCEPTION_MESSAGE={}",ex.getClass().getSimpleName(),ex.getMessage());
    }
}
