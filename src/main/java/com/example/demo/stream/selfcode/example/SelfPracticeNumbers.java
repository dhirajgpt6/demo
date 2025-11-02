package com.example.demo.stream.selfcode.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SelfPracticeNumbers {
    public static void main(String[] args) {

        List<Integer> numberList = Arrays.asList(10,20,30,40,50,10,20,60);

        // Find 2nd largest number in a list OUTPUT: 50
        Optional<Integer> res = numberList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(res.orElse(null));

        // count occurrence of each number. OUTPUT: {50=1, 20=2, 40=1, 10=2, 60=1, 30=1}
        Map<Integer, Long> a=  numberList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(a);

        // print distinct numbers / remove duplicate numbers from list. OUTPUT: [10, 20, 30, 40, 50, 60]
        System.out.println("Distinct numbers:");
        numberList.stream().distinct().forEach(System.out::println);

        // print duplicate numbers OUTPUT: [10, 20]
        List<Integer> re = numberList.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(re);
        //2nd way to find duplicate element from the list
        Set<Integer> duplicates = numberList.stream().filter(n -> Collections.frequency(numberList, n) > 1).collect(Collectors.toSet());
        System.out.println("Duplicates: " + duplicates);

        // print non-repeated numbers. OUTPUT: [30, 40, 50, 60]
        System.out.println("Non-repeated numbers:");
        numberList.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()==1).forEach(e-> System.out.println(e.getKey()));

        //2nd way to find unique element from the list
        System.out.println("Unique numbers:");
        Set<Integer> unique = numberList.stream().filter(n -> Collections.frequency(numberList, n) == 1).collect(Collectors.toSet());
        System.out.println("Unique: " + unique);

        // print top 3 largest numbers from the list
        numberList.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);

        // find first non-repeated number from the list
        numberList.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()==1).findFirst().map(Map.Entry::getKey).ifPresent(e-> System.out.println("First non-repeated number: " + e));

        // find the sum of all number from the list
        Integer sum = numberList.stream().mapToInt(e->e).sum();
        numberList.stream().reduce(0,(Integer::sum));
        System.out.println(sum);

        // find the sum of all even number from the list
        Integer evenNumberSum = numberList.stream().filter(e->e%2==0).mapToInt(e->e).sum();
        System.out.println(evenNumberSum);

        // find the sum of all odd number from the list
        Integer oddNumberSum = numberList.stream().filter(e->e%2!=0).mapToInt(e->e).sum();

        // print odd numbers
        numberList.stream().filter(e->e%2!=0).forEach(System.out::println);

        // Max number from list
        int max = numberList.stream().mapToInt(e -> e).max().orElse(0);
        System.out.println("Max number: " + max);

    }
}
