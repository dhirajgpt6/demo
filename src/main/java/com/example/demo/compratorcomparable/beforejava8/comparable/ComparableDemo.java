package com.example.demo.compratorcomparable.beforejava8.comparable;

import java.util.Arrays;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {
        List<EmployeeComparable> employees =  Arrays.asList(
                new EmployeeComparable(1, "John", 28, 50000),
                new EmployeeComparable(2, "Alice", 24, 60000),
                new EmployeeComparable(3, "Bob", 30, 55000)
        );
        System.out.println("Before Sorting:");
        for (EmployeeComparable emp : employees) {
            System.out.println(emp);
        }
        employees.sort(null); // Sort using natural ordering (by age)
        System.out.println("\nAfter Sorting by Age:");
        for (EmployeeComparable emp : employees) {
            System.out.println(emp);
        }
    }
}
