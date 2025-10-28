package com.example.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UnionArray {
    public int[] union(int[] nums1, int[] nums2) {
        // Using a set to store unique elements
        Set<Integer> set = new HashSet<>();
        System.out.println("HI");
        // Adding elements from the first array
        for (int num : nums1) {
            set.add(num);
        }

        // Adding elements from the second array
        for (int num : nums2) {
            set.add(num);
        }

        // Converting the set back to an array
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        UnionArray ua = new UnionArray();
        int[] nums1 = {1, 2, 2, 9};
        int[] nums2 = {2, 3, 10, 8};
        int[] result = ua.union(nums1, nums2);

        // Printing the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
