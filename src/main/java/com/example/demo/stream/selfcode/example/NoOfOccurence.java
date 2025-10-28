package com.example.demo.stream.selfcode.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Count the nu of occurence of words in given string
//input: "Welcome the java world java world welcome you"
//output: {the=1, world=2, java=2, Welcome=1, welcome=1, you=1}
public class NoOfOccurence {
    public static void main(String[] args) {
        String input = "Welcome the java world java world welcome you";
//        Case 1. BOTH have same logic, difference is 1st is string array and 2nd is List of string
//        String[] list1 = input.split(" ");
//        Map<String, Long> collect = Arrays.stream(list1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect);

//        Case 2
        List<String> list = Arrays.asList(input.split(" "));
        Map<String, Long> result = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);
    }
}

