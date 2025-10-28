package com.example.demo.stream.selfcode.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private int id;
    private long salary;
    private String name;
    private String state;

    public Employee(int id, long salary) {
        this.id = id;
        this.salary = salary;
    }
    public Employee(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public Employee(){}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                '}';
    }
}
