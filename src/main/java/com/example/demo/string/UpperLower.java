package com.example.demo.string;

// Convert the first half of string to lowercase and second half of string in uppercase
//Input: "This is Java Program This is Java Program"
public class UpperLower {
    public static void main(String[] args) {
        String input = "This Is Java Program This is Java Program";
        int mid = input.length()/2;
        String lower = "";
        String upper = "";
        for (int i = 0; i<input.length(); i++){
            if(i<mid){
                lower = lower + Character.toLowerCase(input.charAt(i));
            } else {
                upper = upper + Character.toUpperCase(input.charAt(i));
            }
        }
        System.out.println(lower+upper);
    }
}
