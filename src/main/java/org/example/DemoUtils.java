package org.example;

public class DemoUtils {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int add (int a, int b){
        return a + b;
    }

    public Object checkNull(String obj){
        if(null!=obj) return obj;
        return null;
    }


}