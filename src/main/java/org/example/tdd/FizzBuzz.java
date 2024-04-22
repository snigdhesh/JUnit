package org.example.tdd;


public class FizzBuzz {
    //If number is divisible by 3, print Fizz
    //If number is divisible by 5, print Buzz
    //If number is divisible by 3 and 5, print FizzBuzz
    //If number is not divisible by 3 and 5, then print the number

    //Approach 1

    /*public static String computer(int i) {
        if (i % 3 == 0 && i % 5 == 0) return "FizzBuzz";
        else if (i % 3 == 0) return "Fizz";
        else if (i % 5 == 0) return "Buzz";
        return Integer.toString(i);
    }*/

    //Approach 2
    public static String computer(int i) {
        StringBuilder result = new StringBuilder();
        if (i % 3 == 0) result.append("Fizz");
        if (i % 5 == 0) result.append("Buzz");
        if(result.isEmpty()) result.append(i);
        return result.toString();
    }
}
