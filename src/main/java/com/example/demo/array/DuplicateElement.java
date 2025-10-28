package com.example.demo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Find duplicate elements in an array
public class DuplicateElement {
    public static void main(String[] args) {
        int[] arr = {12, 11, 40, 12, 5, 6, 5, 12, 11};
        List<Integer> duplicates = findDuplicates(arr);
        System.out.println(duplicates);
        List<Integer> duplicates2 = findDuplicates2(arr);
        System.out.println(duplicates2);

    }

    static List<Integer> findDuplicates(int[] arr) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {

                    // Check if the duplicate element is already in res
                    if (!res.contains(arr[i])) {
                        res.add(arr[i]);
                    }
                    break;
                }
            }
        }

        return res;
    }

    static List<Integer> findDuplicates2(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
