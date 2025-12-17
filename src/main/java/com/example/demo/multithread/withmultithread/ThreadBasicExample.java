package com.example.demo.multithread.withmultithread;

public class ThreadBasicExample {
    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName());
                java.lang.Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
    }
}
