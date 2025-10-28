package com.example.demo.stream.selfcode.example;

import com.example.demo.stream.selfcode.dto.Employee;

import java.util.ArrayList;
import java.util.List;
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
