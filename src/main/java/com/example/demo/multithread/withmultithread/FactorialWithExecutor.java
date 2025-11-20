package com.example.demo.multithread.withmultithread;

import java.util.concurrent.*;

public class FactorialWithExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Start time
        long startTime = System.currentTimeMillis();

        // Create a thread pool of fixed size 10
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // List to hold Future objects for results
        Future<Long>[] futures = new Future[10];

        // Submit tasks to executor
        for (int i = 1; i <= 10; i++) {
            int finalI = i; // effectively final for lambda

            // Submit Callable task which returns factorial
            futures[i-1] = executor.submit(() -> factorial(finalI));
        }

        // Wait for all tasks to complete and print results
        for (int i = 0; i < 10; i++) {
            long result = futures[i].get(); // blocks until the task is done
            System.out.println("Fact of " + (i+1) + ":" + result);
        }

        // Shutdown executor
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES); // wait max 1 min for tasks to finish

        // Total time
        System.out.println("Total Time: " + (System.currentTimeMillis() - startTime));
    }

    // Factorial method same as before
    private static long factorial(int i) {
        try {
            Thread.sleep(1000); // simulate long task
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long factorial = 1;
        for (int j = 1; j <= i; j++) {
            factorial *= j;
        }
        return factorial;
    }
}
