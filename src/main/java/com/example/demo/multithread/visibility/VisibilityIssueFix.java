package com.example.demo.multithread.visibility;

public class VisibilityIssueFix {
    // ✅ volatile ensures visibility across threads
    private volatile boolean running = true;

    public void stop() {
        running = false;   // Immediately visible to other threads
    }

    public void runTask() {
        System.out.println("Task started...");
        while (running) {
            // Now loop will exit correctly
        }
        System.out.println("Task stopped!");
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityIssueFix example = new VisibilityIssueFix();

        Thread t1 = new Thread(example::runTask);
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            example.stop();
            System.out.println("Stop called");
        });

        t1.start();
        t2.start();
    }
}
