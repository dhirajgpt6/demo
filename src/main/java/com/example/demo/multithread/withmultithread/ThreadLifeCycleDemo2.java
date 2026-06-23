package com.example.demo.multithread.withmultithread;

public class ThreadLifeCycleDemo2 {
    static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        // =========================
        // 1️⃣ THREAD CREATION ONLY
        // =========================

        Thread t1 = new Thread(() -> {
            System.out.println("Thread-1 started");
            synchronized (lock) {
                try {
                    System.out.println("Thread-1 waiting");
                    lock.wait(); // WAITING
                    System.out.println("Thread-1 RESUMED");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(2000); // TIMED_WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-1 finished");
        });

        Thread t2 = new Thread(() -> {

            synchronized (lock) {
                System.out.println("Thread-2 holding lock");
                try {
                    Thread.sleep(2000); // TIMED_WAITING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {

            synchronized (lock) {
                System.out.println("Thread-3 acquired lock");
            }
        });

        // =========================
        // 2️⃣ EXECUTION FLOW
        // =========================

        System.out.println("State after creation: " + t1.getState()); // NEW

        t1.start();
        System.out.println("HELLO START");

        Thread.sleep(2000);
        System.out.println("State after start: " + t1.getState());

        t2.start();
        Thread.sleep(100);

        t3.start();
        Thread.sleep(100);

        System.out.println("Thread-3 state: " + t3.getState());

        synchronized (lock) {
            lock.notify(); // wakes t1
        }

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Thread-1 final state: " + t1.getState());
        System.out.println("Thread-2 final state: " + t2.getState());
        System.out.println("Thread-3 final state: " + t3.getState());
    }
}
