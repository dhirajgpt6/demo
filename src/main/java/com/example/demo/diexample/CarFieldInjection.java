package com.example.demo.diexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarFieldInjection {
    @Autowired
    private Engine engine; // Field injection

    public void start() {
        System.out.println("CarFieldInjection started.");
        engine.run();
    }

}
