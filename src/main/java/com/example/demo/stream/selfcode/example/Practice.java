package com.example.demo.stream.selfcode.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {
 public static void main(String[] args) {
//  Fetch the 5th element from a List using Streams

//✅ Find the second-highest occurring character in a String
//✅ Print pattern like abbcccdddd from "abcd" using Streams
//✅ Sort Employee objects by name and then salary
//✅ Separate a List into duplicates and unique elements
//✅ Find common elements between two sorted lists
//✅ Remove words that contain any digits
//✅ Print max occurring character from a String (handle ties)
  String input7 =  "bbaaac";
  int[] a = {1,2,3,4};

//✅ Find duplicate words with counts sorted by occurrence (DESC)
  String input8 = "java is java are java is best";
  List<Map.Entry<String, Long>> collect = Arrays.stream(input8.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
          .stream()
          .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
          .filter(e->e.getValue()>1)
          .collect(Collectors.toList());

  System.out.println(collect);
//✅ Print the top 3 longest Strings using Java 8 Streams
  List<String> input =  Arrays.asList("apple", "banana", "java", "apple", "grapes", "java", "abcdedfg", "abc");
  List<String> res = input.stream().sorted(Comparator.comparingInt(String::length).reversed()).limit(3).collect(Collectors.toList());
  System.out.println(res);
 }
}
