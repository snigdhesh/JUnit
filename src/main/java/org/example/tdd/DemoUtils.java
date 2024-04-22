package org.example.tdd;

public class DemoUtils {

    public static void main(String args[]){
        for(int i=1;i<=100;i++){
            System.out.println(FizzBuzz.computer(i));
        }
    }

    public int add (int a, int b){
        return a + b;
    }

    public Object checkNull(String obj){
        if(null!=obj) return obj;
        return null;
    }


}