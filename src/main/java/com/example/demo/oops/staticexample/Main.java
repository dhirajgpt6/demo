package com.example.demo.oops.staticexample;

public class Main {
    public static void main(String[] args) {
        Parent.display(); // Calls Parent's static method
        Child.display();  // Calls Child's static method

        Parent p = new Parent();
        p.display(); // Output: Parent's static display method

        Child c = new Child();
        c.display(); // Output: Child's static display method


        Parent parentRef = new Child();
        parentRef.display(); // Calls Parent's static method due to reference type

    }
}
