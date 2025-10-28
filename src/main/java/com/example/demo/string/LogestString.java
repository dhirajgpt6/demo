package com.example.demo.string;

import java.util.Arrays;
//find the longest string from given array
//String[] s = {"Java", "Hibernet", "Springboot", "microservices"};
public class LogestString {
    public static void main(String[] args) {
        String[] s = {"Java", "Hibernet", "Springboot", "microservices"};

        String result = Arrays.stream(s).reduce((w1, w2)->w1.length()>w2.length()?w1:w2).get();
        System.out.println(result);
    }
}
