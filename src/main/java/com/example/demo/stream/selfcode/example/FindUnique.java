package com.example.demo.stream.selfcode.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Find unique value from ArrayList
//Input: [1,2,3,1,3,4,5]
// Output: [1,2,3,4,5]
public class FindUnique {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
        List<Integer> list = Arrays.asList(1,2,3,1,3,4,5);
        List<Integer> result = list.stream().distinct().collect(Collectors.toList());
        System.out.println(result);
    }
}
