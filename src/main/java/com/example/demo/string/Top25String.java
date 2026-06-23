package com.example.demo.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Top25String {
    public static void main(String[] args) {

//        Number of time words occur in a sentence. Input -> This is my Life and this lifE is good.
        String input = "This is my Life and this lifE is good.";
        Map<String, Long> collect = Arrays.stream(input.split(" ")).map(String::toLowerCase).collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        System.out.println(collect);


        Arrays.stream(input.split(" ")).map(String::toLowerCase).sorted(Comparator.comparing(String::valueOf).reversed()).forEach(System.out::println);
        Arrays.stream(input.split(" ")).map(String::toLowerCase).sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
