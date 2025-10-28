package com.example.demo.leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {2, 1, 8, 6, 4, 6, 5, 5};
        int maxArea1 = maxWater1(height);
        int maxArea2 = maxArea2(height);
        System.out.println("Maximum area: " + maxArea1);
        System.out.println("Maximum area: " + maxArea2);
    }
//brute force approach
    static int maxWater1(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // Calculate the amount of water
                int amount = Math.min(arr[i], arr[j]) * (j - i);

                // Keep track of maximum amount of water
                res = Math.max(amount, res);
            }
        }
        return res;
    }
// Two pointer approach
    public static int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
