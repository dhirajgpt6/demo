package com.example.demo.stream.selfcode.example;

import com.example.demo.stream.selfcode.dto.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Group the employee name based on City
public class Example4 {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee("Raj", "Delhi"));
        empList.add(new Employee("Ram", "Bihar"));
        empList.add(new Employee("Laxman", "Bihar"));
        empList.add(new Employee("Bharat", "Bihar"));
        empList.add(new Employee("Satrudhan", "Delhi"));

        empList.stream().collect(Collectors.groupingBy(Employee::getState)).forEach((key, value) -> {
            System.out.print(key + " = ");
            System.out.println(value.stream().map(Employee::getName).collect(Collectors.joining(", ")));
        });
    }
}

class Solution {
    public double findMaxAverage(int[] nums, int k) {

        // Sum of current window
        double sum = 0;

        // Stores maximum window sum found so far
        double maxSum = 0;

        // Calculate sum of first window of size k
        // Example:
        // nums = [1,12,-5,-6,50,3], k = 4
        // First window = [1,12,-5,-6]
        // sum = 1 + 12 - 5 - 6 = 2
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // First window sum is the initial maximum sum
        maxSum = sum;

        // Slide the window one element at a time
        for (int i = k; i < nums.length; i++) {

            // Add new element entering the window
            // Subtract old element leaving the window
            //
            // Example:
            // Previous window = [1,12,-5,-6] => sum = 2
            //
            // Next window = [12,-5,-6,50]
            //
            // sum = 2 + 50 - 1 = 51
            sum += nums[i] - nums[i - k];

            // Update maximum sum if current window sum is larger
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        // Average = Maximum Window Sum / Window Size
        return maxSum / k;
    }
}