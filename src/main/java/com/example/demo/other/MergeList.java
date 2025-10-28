package com.example.demo.other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//1. Merging two list into single list using java 8
// Input : List1 [1,2,3,4,5]
//         List2 [3,4,5,6,7,8]
// Output: MergedList [1,2,3,4,5,3,4,5,6,7,8]

//2. Remove Duplicate from MergedList and print only unique elements
//Input: MergedList [1,2,3,4,5,3,4,5,6,7,8]
//uniqueElements [1,2,3,4,5,6,7,8]
public class MergeList {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5,6,7,8);

//        1.
        List<Integer> mergeList = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println(mergeList);

//        2.
        List<Integer> unique = mergeList.stream().distinct().collect(Collectors.toList());
        System.out.println(unique);
    }
}