package com.example.demo.other;

//program to find a number is even or odd number without using moduler(%) operatoer

public class OddEvenWithoutModuler {
    public static void main(String[] args) {
        int input = 5;
        int quotient = input/2; // return bhagphal

//        Approach 1:
        if(quotient*2 == input){
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }

//        Approach 2: using bit operator
        if((input & 1) == 0){
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }
}
