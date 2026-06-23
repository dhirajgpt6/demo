package com.example.demo.multithread.stepwise.step3;

class Counter {

    private int count = 0;
    private final int MAX_LIMIT = 20;

    // Producer
    public synchronized void increment() throws InterruptedException {
        while (count == MAX_LIMIT) {
            System.out.println(Thread.currentThread().getName()
                    + " waiting to PRODUCE...");
            wait();
        }

        count++;
        System.out.println(Thread.currentThread().getName()
                + " produced, count = " + count);

        notifyAll(); // wake consumers
    }

    // Consumer
    public synchronized void decrement() throws InterruptedException {
        while (count == 0) {
            System.out.println(Thread.currentThread().getName()
                    + " waiting to CONSUME...");
            wait();
        }

        count--;
        System.out.println(Thread.currentThread().getName()
                + " consumed, count = " + count);

        notifyAll(); // wake producers
    }
}


