package com.example.demo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Find the missing number from array
//Input : {1,2,3,4,5,7,8,9,10}
//Output: Missing number is : 6
public class FindMissingNumber {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1,2,3,4,5,7,8,9,10);

//        int[] array = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int n = 10; // Largest number in the sequence

        // Sum of first n natural numbers
        int totalSum = n * (n + 1) / 2;

        // Sum of elements in the array
        int arraySum = 0;
        for (int num : array) {
            arraySum += num;
        }

        // Find the missing number
        int missingNumber = totalSum - arraySum;

        System.out.println("The missing number is: " + missingNumber);
    }
}
