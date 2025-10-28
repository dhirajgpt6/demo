package com.example.demo.stream.selfcode.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Find duplicate value from ArrayList
//Input: [5,12,21,12,3,41,5,41]
// Output: [5,12,41]
public class FindDuplicate {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5,12,21,12,3,41,5,41);
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = list.stream().filter(x->!set.add(x)).collect(Collectors.toSet());
        System.out.println(result);

        // find the sum of all even number from the list
        Integer evenNumberSum = list.stream().filter(e->e%2==0).mapToInt(sum->sum).sum();
        System.out.println(evenNumberSum);
    }
}
