package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private int age;
    private String active;
    private String department;
    private int yearOfJoining;
    private double salary;

    @Override
    public String toString() {
        return "Employee: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", active='" + active + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary;
    }
}
