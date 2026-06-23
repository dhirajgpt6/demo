package com.example.demo.string;

import java.util.Arrays;
import java.util.Comparator;

//find the longest string from given array
//String[] s = {"Java", "Hibernet", "Springboot", "microservices"};
public class LogestString {
    public static void main(String[] args) {
        String[] s = {"Java", "Hibernet", "Springboot", "microservices"};
        //1st Way
        String result = Arrays.stream(s).reduce((w1, w2)->w1.length()>w2.length()?w1:w2).get();
        System.out.println(result);
        //2nd Way
        Arrays.asList(s).stream().max(Comparator.comparing(String::length)).ifPresent(System.out::println);
        //3rd way
        String s2 = Arrays.stream(s).sorted(Comparator.comparing(String::length).reversed()).findFirst().orElse("");
        System.out.println("Sorted way se: " +s2);
        //4th way
        String longestString = "";
        for(String s1 : s) {
            if(s1.length()>longestString.length()) {
                longestString = s1;
            }
        }
        System.out.println(longestString);
    }
}
