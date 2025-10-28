package com.example.demo.compratorcomparable.beforejava8.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {
//        List<Employee> employees = Arrays.asList(
//                new Employee(1, "John", 28, 50000),
//                new Employee(2, "Alice", 24, 60000),
//                new Employee(3, "Bob", 30, 55000)
//        );

        ArrayList<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(1, "John", 28, 50000),
                new Employee(2, "Alice", 24, 60000),
                new Employee(3, "Bob", 30, 55000)
        ));

        System.out.println("Before Sorting:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        Collections.sort(employees, new AgeComparator()); // Sort by age
        System.out.println("\nAfter Sorting by Age:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        Collections.sort(employees, new SalaryComparator()); // Sort by salary
        System.out.println("\nAfter Sorting by Salary:");
        for (Employee employee: employees){
            System.out.println(employee);
        }
    }
}
