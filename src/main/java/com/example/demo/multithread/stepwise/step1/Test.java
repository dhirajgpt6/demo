package com.example.demo.multithread.stepwise.step1;

/*
isme 4 thread bnaya start kiya or counter ko badhaya, without any syncronization to
OUTPUT expected 400000
but getting 198989 or 200087 not fixed
due to race condition. next example me Counter class me increment method ko synchronized kr dunga to shi ho jayega... race condition nhi hogi

 */
public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 100000; i++) {
//                System.out.println(Thread.currentThread().getName() + ": " + i);
                counter.increment();
            }
            System.out.println(Thread.currentThread().getName());
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());
    }
}
