package com.example.demo.functional;

//write a program to multiply 2 numbers using functional interface
public class Multiply {
    public static void main(String[] args) {
        FunInterface total = (a,b) -> a*b;
        int result = total.multiply(10, 20);
        System.out.println(result);
    }
}
