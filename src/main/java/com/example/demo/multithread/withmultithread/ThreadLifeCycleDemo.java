package com.example.demo.multithread.withmultithread;

public class ThreadLifeCycleDemo {

    // common lock object
    static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        // ---------------------------
        // 1️⃣ NEW State
        // ---------------------------
        Thread t1 = new Thread(() -> {
            System.out.println("Thread-1 started");

            // ---------------------------
            // 4️⃣ WAITING State (wait)
            // ---------------------------
            synchronized (lock) {
                try {
                    System.out.println("Thread-1 waiting");
                    lock.wait();   // WAITING
                    System.out.println("Thread-1 RESUMED");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // ---------------------------
            // 5️⃣ TIMED_WAITING (sleep)
            // ---------------------------
            try {
                System.out.println("Thread-1 inside try after resumed");
                Thread.sleep(2000); // TIMED_WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread-1 finished"); // TERMINATED
        });

        System.out.println("State after creation: " + t1.getState()); // NEW

        // ---------------------------
        // 2️⃣ RUNNABLE State
        // ---------------------------
        System.out.println("HELLO START");
        t1.start();
        Thread.sleep(2000); // small delay
        System.out.println("State after start: " + t1.getState());

        // ---------------------------
        // BLOCKED State Example
        // ---------------------------
        Thread t2 = new Thread(() -> {
            synchronized (lock) {  // holds lock
                System.out.println("Thread-2 holding lock");
                try {
                    Thread.sleep(2000); // TIMED_WAITING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2.start();
        Thread.sleep(100);

        Thread t3 = new Thread(() -> {
            synchronized (lock) {  // BLOCKED (lock already with t2)
                System.out.println("Thread-3 acquired lock");
            }
        });

        t3.start();
        Thread.sleep(100);

        System.out.println("Thread-3 state (BLOCKED): " + t3.getState());

        // ---------------------------
        // NOTIFY WAITING THREAD
        // ---------------------------
        synchronized (lock) {
            lock.notify(); // wakes t1 from WAITING
        }

        // wait for threads to finish
        t1.join();
        t2.join();
        t3.join();

        // ---------------------------
        // 6️⃣ TERMINATED State
        // ---------------------------
        System.out.println("Thread-1 final state: " + t1.getState());
        System.out.println("Thread-2 final state: " + t2.getState());
        System.out.println("Thread-3 final state: " + t3.getState());
    }
}
