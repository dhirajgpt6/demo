package com.example.demo.diexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        // Using Constructor Injection
        Engine engine1 = new Engine();
        CarConstructorInjection car1 = new CarConstructorInjection(engine1);
        car1.start();

        // Using Setter Injection
        Engine engine2 = new Engine();
        CarSetterInjection car2 = new CarSetterInjection();
        car2.setEngine(engine2);
        car2.start();

        // Using Field Injection (requires Spring context, so this is just illustrative)
        // In a real Spring application, you would get this bean from the Spring context
//         ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//         CarFieldInjection car3 = context.getBean(CarFieldInjection.class);
//         car3.start();
    }
}
