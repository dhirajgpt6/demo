package com.example.demo.stream.selfcode.example;

import java.util.*;
import java.util.stream.Collectors;

public class Top25Question {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50, 51, 52, 53, 40, 50);

        System.out.println("1) Given the list of Integers, find the first element of the list using stream functions");
        Integer firstNumber = nums.stream().findFirst().get();
        System.out.println(firstNumber);

        System.out.println("2) Given the list of Integers, find the total number of elements present in the list using Stream function");
        long count = nums.stream().count();
        System.out.println(count);

        System.out.println("3) Given the list of Integers, find out all the even and odd numbers that exist in list");
        List<Integer> evenNumbers = nums.stream().filter(x -> x % 2 == 0).toList();
        List<Integer> oddNumbers = nums.stream().filter(x -> x % 2 != 0).toList();
        System.out.println(evenNumbers);
        System.out.println(oddNumbers);

        System.out.println("4) Given the list of Integer, find out all the number start with 5");
        nums.stream().filter(x->x.toString().startsWith("5")).forEach(System.out::println);

        System.out.println("5) Find out the duplicate elements in a given Integer List");
//        create a set and add element in set
        Set<Integer> set = new HashSet<>();
        nums.stream().filter(x-> !set.add(x)).forEach(System.out::println);

        System.out.println("6)  Given the list of Integer, find the maximum and minimum element present in List");
        System.out.println(nums.stream().min(Integer::compareTo).orElse(null));
        System.out.println(nums.stream().max(Integer::compareTo).orElse(null));

        System.out.println("7) Given the list of Integer, sort in ascending order ");
        List<Integer> ascendingList = nums.stream().sorted().toList();
        System.out.println(ascendingList);

        System.out.println("8) Given the list of Integer, sort in descending order ");
        List<Integer> descendingList = nums.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(descendingList);

        System.out.println("9) Check array contain duplicate values or not");
        int[] numbers = {1,2,3,4,1,5};
        if(Arrays.stream(numbers).distinct().count() != numbers.length){
            System.out.println("Have Duplicate Values");
        } else {
            System.out.println("Not have duplicate values");
        }

        // find duplicate element from the list
        Set<Integer> duplicates = nums.stream().filter(n -> Collections.frequency(nums, n) > 1).collect(Collectors.toSet());
        System.out.println("Duplicates: " + duplicates);

        //find unique elements from the list
        Set<Integer> unique = nums.stream().filter(n -> Collections.frequency(nums, n) == 1).collect(Collectors.toSet());
        System.out.println("Unique: " + unique);
    }
}
