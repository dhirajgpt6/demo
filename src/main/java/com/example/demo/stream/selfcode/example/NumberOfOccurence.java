package com.example.demo.stream.selfcode.example;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
//  Capgemini
//  Find the frequency/occurence of each character in a string using java 8 streams.
//  Input: "Java Concept of the day"
public class NumberOfOccurence {
    public static void main(String[] args) {
        String inputString = "Java Conept Of The Day";

//        CASE 1
        Map<Character, Long> charCountMap = inputString.chars()
                .mapToObj(c-> (char)c)  // Convert int to char
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCountMap);

//        CASE 2
        Map<Character, Long> charCountMapWithoutSpace = inputString.chars()
                .mapToObj(c-> (char)c).filter(c -> !Character.isWhitespace(c))  // Convert int to char
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCountMapWithoutSpace);

//        CASE 3
        Map<Character, Long> charCountMapLowercase = inputString.chars()
                .mapToObj(c-> (char)c).filter(c -> !Character.isWhitespace(c))  // Convert int to char
                .collect(Collectors.groupingBy(Character::toLowerCase, Collectors.counting()));
        System.out.println(charCountMapLowercase);
    }
}
