package com.example.demo.oops.inheritance;

public class Main {
    public static void main(String[] args) {

        Parent p = new Parent();
        p.display(); // Output: Parent's display method

        Child c = new Child();
        c.display(); // Output: Child's display method


        Parent parentRef = new Child();
        parentRef.display(); // Calls Child's method due to reference type

    }
}
