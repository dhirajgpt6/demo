package com.example.demo.leetcode;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap max and min when multiplied by a negative number
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Update max and min products
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            // Update the result with the maximum product found so far
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
