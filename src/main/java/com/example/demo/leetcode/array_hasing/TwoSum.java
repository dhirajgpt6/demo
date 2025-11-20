package com.example.demo.leetcode.array_hasing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15}; //
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
//   public static int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> numMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (numMap.containsKey(complement)) {
//                return new int[]{numMap.get(complement), i};
//            }
//            numMap.put(nums[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//    brute-force approach
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
