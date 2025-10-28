package com.example.demo.stream.gitcode.dto;

import lombok.Data;

@Data
public class Student {

    String name;
    int grade;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}
