package com.example.demo.multithread.stepwise.step2;

public class Counter {
    int count = 0;
    synchronized void increment() {
        System.out.println("Incrementing...." +Thread.currentThread().getName()+ ": " +count);
        count++;
    }
    public int getCount() {
        return count;
    }
}
