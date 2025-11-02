package com.example.demo.stream.selfcode.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Find duplicate value from ArrayList
//Input: [5,12,21,12,3,41,5,41]
// Output: [5,12,41]
public class FindDuplicate {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,12,21,12,3,41,5,41);
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = list.stream().filter(x->!set.add(x)).collect(Collectors.toSet());
        System.out.println(result);

        // find the sum of all even number from the list
        Integer evenNumberSum = list.stream().filter(e->e%2==0).mapToInt(sum->sum).sum();
        Integer evenNumberSum2 = list.stream().filter(e->e%2==0).reduce(0,(a,b)->a+b);
        Integer evenNumberSum3 =list.stream().filter(e->e%2==0).reduce(0,Integer::sum);

        System.out.println(evenNumberSum);
        System.out.println(evenNumberSum2);
        System.out.println(evenNumberSum3);

        // find first non-repeated number from the list
        List<Integer> numbers = List.of(4, 5, 1, 2, 1, 4, 3, 5);
        Map<Integer, Long> res = numbers.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        System.out.println(res);
        res.entrySet().stream().filter(e->e.getValue()==1).findFirst().ifPresent(e-> System.out.println("First non-repeated number: " + e.getKey()));
        Integer r = numbers.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting())).entrySet().stream()
                .filter(e->e.getValue()==1).map(e->e.getKey())
                .findFirst().orElse(null);
        System.out.println(r);
        Integer sum = numbers.stream().reduce(0,((a,b)-> a+b));
        Integer sum2 = numbers.stream().mapToInt(Integer::intValue).sum();
        Integer sum3 = numbers.stream().mapToInt(s->s).sum();
        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3);
    }
}
