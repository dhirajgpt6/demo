package com.example.demo.diexample;

public class CarSetterInjection {
    private Engine engine;

    // Setter Injection
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        if (engine == null) {
            throw new IllegalStateException("Engine not set!");
        }
        engine.run();
        System.out.println("Car started.");
    }
}
