package com.example.demo.stream.selfcode.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example3 {
    public static void main(String[] args) {
//find the string which start and end with same word
        List<String> data = Arrays.asList("abc", "mnm", "xlx", "xyz", "fkf", "qwe");
        data.stream().filter(x-> !x.isEmpty() && x.endsWith(String.valueOf(x.charAt(0)))).forEach(System.out::println);

        // fetch the longest name from the list
        System.out.println("Longest name from the list");
        List<String> nameList = Arrays.asList("Ram", "Shyam", "Mohan", "So", "Ramesh","Raghunath");
        nameList.stream().max((x,y)->x.length()-y.length()).ifPresent(System.out::println);
        nameList.stream().reduce((a,b)-> a.length()>b.length()?a:b).ifPresent(System.out::println);

        // fetch the duplicate number from the list
        System.out.println("Duplicate number from the list");
        List<Integer> numberList = Arrays.asList(10,20,30,40,50,10,20,60);
        Set<Integer> duplicateNumbers = new HashSet<>();
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer i : numberList) {
            System.out.println(numberList.indexOf(i));
            System.out.println(numberList.lastIndexOf(i));
            uniqueNumbers.add(i);
            if(numberList.indexOf(i) != numberList.lastIndexOf(i)){
                duplicateNumbers.add(i);
            }

        }
        System.out.println("Duplicates: " +duplicateNumbers);
        System.out.println("Unique: " +uniqueNumbers);

//        System.out.println("1st way");
//        numberList.stream().filter(i-> numberList.indexOf(i) != numberList.lastIndexOf(i)).distinct().forEach(System.out::println);
//        System.out.println("2nd way");
//        numberList.stream().filter(e-> numberList.stream().filter(x->x.equals(e)).count()>1).distinct().forEach(System.out::println);
//        System.out.println("3rd way");
//        numberList.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()))
//                .entrySet().stream().filter(x->x.getValue()>1).map(x->x.getKey()).forEach(System.out::println);
//        System.out.println("4th way");
//        numberList.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()))
//                .entrySet().stream().filter(x->x.getValue()>1).forEach(x-> System.out.println(x.getKey()));
//        System.out.println("5th way");
//        numberList.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()))
//                .entrySet().stream().filter(x->x.getValue()>1).forEach(System.out::println);

        Map<Integer, Long> res = numberList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Map<Integer, Long> res1 = numberList.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        Long res2 = numberList.stream().collect(Collectors.counting());
        System.out.println(res2);
        // count the occurence of each number from the list
        System.out.println("Count the occurence of each number from the list");
        Map<Integer, Long> occurenceMap = numberList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // find the top 3 max number from the list
        System.out.println("Top 3 max number 1st way");
        numberList.stream().sorted((a,b)->b-a).limit(3).forEach(System.out::println);
        System.out.println("Top 3 max number 2nd way");
        numberList.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
    }
}
