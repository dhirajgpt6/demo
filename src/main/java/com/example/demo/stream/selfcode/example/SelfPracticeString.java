package com.example.demo.stream.selfcode.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SelfPracticeString {
    public static void main(String[] args) {
        // 1. Count occurrence of each character in a string
        // 1st way to count occurrence of each character in a string
        System.out.println("1. Count occurrence of each character in a string");
        String inputString = "India is my country";
        Map<String, Long> resWithSpace = Arrays.asList(inputString.split("")).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(resWithSpace);

        Map<String, Long> resWithoutSpace = Arrays.asList(inputString.split("")).stream()
                .filter(e->!e.isBlank())// to ignore space
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(resWithoutSpace);

        // 2nd way to count occurrence of each character in a string
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

        // 2. Count occurrence of each Word in a string Paragraph
        System.out.println("1. Count occurrence of each Word in a string Paragraph");
        String input = "Welcome the java world java world welcome you";
        Map<String, Long> result = Arrays.asList(input.split(" ")).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);

        // 3. Find palindrome form a list of strings
        System.out.println("2. Find palindrome in a list of strings");
        List<String> strList = Arrays.asList("madam", "hello", "racecar", "world", "level");
        List<String> palindromeList = strList.stream()
                .filter(s -> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString())).toList();
        System.out.println(palindromeList);


    }
}
