package com.example.demo.stream.selfcode.example;

import com.example.demo.stream.selfcode.dto.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//Delloitte Interview question
//1. sort the employee based on their salary in desc order
//2. Fetch top 3 salaried employees details.
//3. Fetch all employee having salary less than 3rd highest salary.
public class Example1 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(1, 500));
        employeeList.add(new Employee(2, 1000));
        employeeList.add(new Employee(3, 1500));
        employeeList.add(new Employee(4, 2000));
        employeeList.add(new Employee(5, 2500));
        employeeList.add(new Employee(6, 3000));
        employeeList.add(new Employee(7, 3500));
        System.out.println(employeeList);
//        1
        List<Employee> empSorted = employeeList.stream().sorted(((o1, o2) -> Math.toIntExact(o2.getSalary() - o1.getSalary()))).collect(Collectors.toList());
        //employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());
        System.out.println(empSorted);
//        2
        List<Employee> hightesttheeemp = empSorted.stream().limit(3).collect(Collectors.toList());
        System.out.println(hightesttheeemp);
//        3
        List<Employee> lessThan3rdHighestSalary = empSorted.stream().skip(3).collect(Collectors.toList());
        System.out.println(lessThan3rdHighestSalary);


    }
}
