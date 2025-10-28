package com.example.demo.compratorcomparable.beforejava8.comparable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeComparable implements Comparable<EmployeeComparable> {
    private int age;
    private int id;
    private int salary;
    private String name;

    public EmployeeComparable(int id, String name, int age, int salary) {
        this.age = age;
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(EmployeeComparable o) {
        return Integer.compare(this.age, o.age);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return id == employee.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

}
