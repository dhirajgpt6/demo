package com.example.demo.diexample;

public class CarConstructorInjection {
    private Engine engine;

    // Constructor Injection
    public CarConstructorInjection(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.run();
        System.out.println("Car started.");
    }
}
