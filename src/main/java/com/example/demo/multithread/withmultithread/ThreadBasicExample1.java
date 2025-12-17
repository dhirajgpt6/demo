package com.example.demo.multithread.withmultithread;

public class ThreadBasicExample1 {
    public static void main(String[] args) {
        Runnable task = new MyRunnable();
        Runnable task1 = () -> {
                System.out.println(Thread.currentThread().getName());
        };


        Thread t1 = new Thread(task);
        t1.start();

        Thread t2 = new Thread(task1);
        t2.start();

        System.out.println(
                "Main thread: " + Thread.currentThread().getName()
        );
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(
                "Runnable thread: " + Thread.currentThread().getName()
        );
    }
}