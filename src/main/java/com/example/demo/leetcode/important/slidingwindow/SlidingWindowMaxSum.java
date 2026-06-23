package com.example.demo.leetcode.important.slidingwindow;

public class SlidingWindowMaxSum {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + " is: " + findMaxSum(arr, k));
    }
    public static int findMaxSum(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1; // Case if array is smaller than window

        int windowSum = 0;
        int maxSum = 0;

        // 1. Pehli window ka sum nikal lo (0 to k-1)
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // 2. Window ko slide karo (k se end tak)
        for (int i = k; i < n; i++) {
            // Naya element add karo, purana (i-k) subtract karo
            windowSum += arr[i] - arr[i - k];

            // Max sum update karo
            maxSum = Math.max(maxSum, windowSum);
        }
        System.out.println();
        return maxSum;
    }
}
