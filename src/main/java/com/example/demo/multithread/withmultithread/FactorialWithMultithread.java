package com.example.demo.multithread.withmultithread;
// Case 1: 1 से 10 तक फैक्टोरियल निकालने में कुल समय 9MS लगता है
// Case 2: जब मैं मेन थ्रेड को 1000 ms यानी 1 सेकंड के लिए स्लीप कर देता हूँ, तो कुल समय: 10037MS लगता है
// मतलब मैंने मान लिया कि कोई काम (फैक्टोरियल निकालने में) करने में 1s का समय लगता है, तो 10 नंबर का फैक्टोरियल निकालने में करीब 10s लग गए।
// मतलब अभी तक मैंने कोई मल्टीथ्रेडिंग नहीं लगाई है… बस Thread.sleep लगाया, मेन थ्रेड को 1s के लिए स्लीप करने के लिए…
// ताकि यह महसूस हो सके कि 1 नंबर का फैक्टोरियल निकालने में 1s का समय लगता है, तो 10 नंबर का निकालने में 10s लगेगा

// Ab isme multithreading apply krte hai to kya kam krta hai.. kitna time leta hai.. lets see....
public class FactorialWithMultithread {
    public static void main(String[] args) {
        // Record the start time of the program to calculate total execution time
        long startTime = System.currentTimeMillis();

        // Create an array to hold 10 threads (one for each number 1 to 10)
        Thread[] threads = new Thread[10];

        // Loop from 1 to 10 to create threads for each factorial calculation
        for(int i = 1; i <= 10; i++) {
            // i is not effectively final, so we create a final copy for use inside lambda
            int finalI = i;

            // Create a new Thread to calculate factorial of finalI
            threads[i-1] = new Thread(
                    () -> {
                        // Call factorial method and store the result
                        long result = factorial(finalI);
                        // Print the result for this number
                        System.out.println("Fact of " + finalI + ":" + result);
                    }
            );

            // Start the thread immediately after creating it
            threads[i-1].start();

//            // Old synchronous way to calculate factorial (commented out)
//            System.out.println("Factorial of " + i + "-" + factorial(i));
        }

        // Wait for all threads to finish using join()
        for (Thread thread : threads) {
            try {
                // join() blocks the main thread until this thread completes
                thread.join();
            } catch (InterruptedException e) {
                // Wrap InterruptedException into RuntimeException if occurs
                throw new RuntimeException(e);
            }
        }

        // Calculate and print the total time taken for all factorial calculations
        System.out.println("Total Time: " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long factorial = 1;
        for(int j = 1; j<= i; j++){
         factorial = factorial * j;
        }
        return factorial;
    }
}
