package com.example.demo.common;

import org.apache.catalina.realm.CombinedRealm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonPractice {
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

















    private static void createEmployeeList(List<Employee> empList){
        empList.add(new Employee(111, "Ram", 32, "No", "HR", 2000, 9000));
        empList.add(new Employee(112, "Laxman", 20, "Yes", "Java", 2001, 9000));
        empList.add(new Employee(113, "Bharat", 18, "No", "Java", 2001, 22000));
        empList.add(new Employee(114, "Strudhan", 20, "No", "Java", 2001, 25000));
        empList.add(new Employee(115, "Rahim", 22, "Yes", "Python", 2002, 60000));
        empList.add(new Employee(116, "Krishna", 30, "Yes", "HR", 2000, 43000));
        empList.add(new Employee(117, "Hanuman", 30, "No", "HR", 2000, 54000));
        empList.add(new Employee(118, "Shiv", 31, "No", "Python", 2002, 23000));
        empList.add(new Employee(119, "Vishnu", 33, "Yes", "Finance", 2002, 65000));
        empList.add(new Employee(120, "ShaniDev", 40, "Yes", "Finance", 2000, 83000));
    }
}
