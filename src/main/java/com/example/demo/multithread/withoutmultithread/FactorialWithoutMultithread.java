package com.example.demo.multithread.withoutmultithread;
// Case 1: 1 से 10 तक फैक्टोरियल निकालने में कुल समय 9MS लगता है
// Case 2: जब मैं मेन थ्रेड को 1000 ms यानी 1 सेकंड के लिए स्लीप कर देता हूँ, तो कुल समय: 10037MS लगता है
// मतलब मैंने मान लिया कि कोई काम (फैक्टोरियल निकालने में) करने में 1s का समय लगता है, तो 10 नंबर का फैक्टोरियल निकालने में करीब 10s लग गए।
// मतलब अभी तक मैंने कोई मल्टीथ्रेडिंग नहीं लगाई है… बस Thread.sleep लगाया, मेन थ्रेड को 1s के लिए स्लीप करने के लिए…
// ताकि यह महसूस हो सके कि 1 नंबर का फैक्टोरियल निकालने में 1s का समय लगता है, तो 10 नंबर का निकालने में 10s लगेगा
public class FactorialWithoutMultithread {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for(int i=1; i<=10; i++){
            System.out.println("Factorial of " +i +"-" +factorial(i));
        }
        System.out.println("Total Time: " +(System.currentTimeMillis() - startTime)); //Total Time: 9
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
