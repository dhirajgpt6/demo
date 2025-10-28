package com.example.demo.stream.gitcode.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class Person {

    private String name;
    private int age;

    public Person(String name,int age) {
        this.name = name;
        this.age = age;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && age == person.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
