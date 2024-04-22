package org.example.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {
    //If number is divisible by 3, print Fizz
    //If number is divisible by 5, print Buzz
    //If number is divisible by 3 and 5, print FizzBuzz
    //If number is not divisible by 3 and 5, then print the number

    @Test
    @Order(1)
    @DisplayName("Divisible by 3")
    void testForDivisibleByThree(){
        String expected = "Fizz";
        assertEquals(expected,FizzBuzz.computer(3),"should return Fizz");
    }

    @Test
    @Order(2)
    @DisplayName("Divisible by 5")
    void testForDivisibleByFive(){
        String expected = "Buzz";
        assertEquals(expected,FizzBuzz.computer(5),"should return Buzz");
    }


    @Test
    @Order(3)
    @DisplayName("Divisible by 3 and 5")
    void testForDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";
        assertEquals(expected,FizzBuzz.computer(15),"should return FizzBuzz");
    }


    @Test
    @Order(4)
    @DisplayName("Not divisible by 3 and 5")
    void testForNotDivisibleByThreeAndFive(){
        String expected = "1";
        assertEquals(expected,FizzBuzz.computer(1),"should return number");
    }

    @DisplayName("Test with small CSV data")
    @ParameterizedTest(name="input value={0},expected output={1}")
    @Order(5)
    @CsvFileSource(resources = "/testData.csv")
    void testCSVData(String value, String expected){
        assertEquals(expected,FizzBuzz.computer(Integer.parseInt(value)));
    }


    @DisplayName("Test with medium CSV data")
    @ParameterizedTest(name="input value={0},expected output={1}")
    @Order(6)
    @CsvFileSource(resources = "/mdTestData.csv")
    void testMediumCSVData(String value, String expected){
        assertEquals(expected,FizzBuzz.computer(Integer.parseInt(value)));
    }

    @DisplayName("Test with larget CSV data")
    @ParameterizedTest(name="input value={0},expected output={1}")
    @Order(7)
    @CsvFileSource(resources = "/lgTestData.csv")
    void testLargeCSVData(String value, String expected){
        assertEquals(expected,FizzBuzz.computer(Integer.parseInt(value)));
    }
}
