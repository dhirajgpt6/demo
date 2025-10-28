package com.example.demo.stream.selfcode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Employee2 {
    private int id;
    private String name;
    private int age;
    private String active;
    private String department;
    private int yearOfJoining;
    private double salary;

    @Override
    public String toString() {
        return "Employee2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", active='" + active + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';
    }
}
