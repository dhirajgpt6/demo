package com.example.demo.multithread.withmultithread;

import java.util.concurrent.*;

public class ExecutorServiceBasicExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1️⃣ Create ExecutorService with fixed thread pool (2 threads)
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 2️⃣ Runnable task (no return value)
        Runnable task1 = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task 1 running on " +
                    Thread.currentThread().getName());
        };

        Runnable task2 = () -> {
            System.out.println("Task 2 running on " +
                    Thread.currentThread().getName());
        };

        // 3️⃣ Submit Runnable tasks
        executor.execute(task1);
        executor.execute(task2);
//########################
        Future<Integer> re =  executor.submit(()->{
            try {
                Thread.sleep(5000);
                return 33;
            } catch (InterruptedException e) {}
            return 42;
        });
        System.out.println(re.get());
//########################

        Callable<Integer> task3 = () -> {
            System.out.println("Task 3 running on " +
                    Thread.currentThread().getName());
            return 10;
        };
        Future<Integer> future1 = executor.submit(task3);
//########################

        // 4️⃣ Callable task (returns value)
        Future<Integer> future = executor.submit(() -> {
            System.out.println("Callable task running on " +
                    Thread.currentThread().getName());
            return 10 + 20;
        });

        try {
            // 5️⃣ Get result from Callable
            Integer result = future.get(); // waits if needed
            System.out.println("Callable result = " + result);
            System.out.println("Future result = " +future1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 6️⃣ Shutdown ExecutorService (VERY IMPORTANT)
        executor.shutdown();

        System.out.println("Main thread finished");
    }
}
