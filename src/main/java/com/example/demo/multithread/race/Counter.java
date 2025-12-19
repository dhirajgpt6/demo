package com.example.demo.multithread.race;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    // ❌ NOT THREAD SAFE
    // 'count++' atomic operation nahi hai
    // Multiple threads ek hi time par read/write kar sakte hain
    private int count = 0;

    public void counterIncrement() {
        count++; // Race condition yahin hoti hai
    }

    public int getCount() {
        return count;
    }

    // ✅ THREAD SAFE (Lock-free)
    // AtomicInteger internally CAS (Compare-And-Swap) use karta hai
    AtomicInteger atomicCount = new AtomicInteger(0);

    public void counterIncrementAtomic() {
        atomicCount.incrementAndGet(); // Atomic operation
    }

    public int getAtomicCount() {
        return atomicCount.get();
    }

    // ✅ THREAD SAFE (Lock based)
    // synchronized method ek time par sirf ek thread ko allow karta hai
    private int countSync = 0;

    synchronized public void incrementSync() {
        countSync++; // Critical section protected by monitor lock
    }

    public int getCountSync() {
        return countSync;
    }

    public static void main(String[] args) {

        Counter counter = new Counter();

        // Thread 1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.counterIncrement();        // ❌ unsafe
                counter.incrementSync();           // ✅ safe
                counter.counterIncrementAtomic();  // ✅ safe
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.counterIncrement();        // ❌ unsafe
                counter.incrementSync();           // ✅ safe
                counter.counterIncrementAtomic();  // ✅ safe
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Expected value = 20000
        System.out.println("Normal Count (Not Thread Safe): " + counter.getCount());
        System.out.println("Atomic Count (Thread Safe): " + counter.getAtomicCount());
        System.out.println("Synchronized Count (Thread Safe): " + counter.getCountSync());
    }
}
