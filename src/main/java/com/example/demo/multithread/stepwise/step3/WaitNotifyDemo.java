package com.example.demo.multithread.stepwise.step3;

public class WaitNotifyDemo {

    public static void main(String[] args) {

        Counter counter = new Counter();

        Runnable producer = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    counter.increment();
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable consumer = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    counter.decrement();
                    Thread.sleep(150);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(producer, "Producer-1").start();
        new Thread(producer, "Producer-2").start();
        new Thread(consumer, "Consumer-1").start();
        new Thread(consumer, "Consumer-2").start();
    }
}
