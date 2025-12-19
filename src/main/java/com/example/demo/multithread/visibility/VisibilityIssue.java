package com.example.demo.multithread.visibility;

public class VisibilityIssue {
    // ❌ Not volatile → visibility issue
    private boolean running = true;

    public void stop() {
        running = false;   // Writer thread updates value
    }

    public void runTask() {
        System.out.println("Task started...");
        while (running) {
            // Busy loop
            // Thread may NEVER see running=false
        }
        System.out.println("Task stopped!");
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityIssue example = new VisibilityIssue();

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
