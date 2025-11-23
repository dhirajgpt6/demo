package com.example.demo.common;

import org.apache.catalina.realm.CombinedRealm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonPractice {
    public static void main(String[] args) {

    }

















    private static void createEmployeeList(List<Employee> empList){
        empList.add(new Employee(111, "Ram", 32, "No", "HR", 2000, 9000));
        empList.add(new Employee(112, "Laxman", 20, "Yes", "Java", 2001, 9000));
        empList.add(new Employee(113, "Bharat", 18, "No", "Java", 2001, 22000));
        empList.add(new Employee(114, "Strudhan", 20, "No", "Java", 2001, 25000));
        empList.add(new Employee(115, "Rahim", 22, "Yes", "Python", 2002, 60000));
        empList.add(new Employee(116, "Krishna", 30, "Yes", "HR", 2000, 43000));
        empList.add(new Employee(117, "Hanuman", 30, "No", "HR", 2000, 54000));
        empList.add(new Employee(118, "Shiv", 31, "No", "Python", 2002, 23000));
        empList.add(new Employee(119, "Vishnu", 33, "Yes", "Finance", 2002, 65000));
        empList.add(new Employee(120, "ShaniDev", 40, "Yes", "Finance", 2000, 83000));
    }
}
