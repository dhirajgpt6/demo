package com.example.demo.other;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateOTP {
    public static void main(String[] args) {
//        OPTION 1
        int otp = ThreadLocalRandom.current().nextInt(1000, 10000); // Range: 1000 to 9999
        System.out.println("Your 4-digit OTP is: " + otp);

//        OPTION 2
        Random random = new Random();
        int otp1 = 1000 + random.nextInt(9000); // Ensures a number between 1000 and 9999
        System.out.println("Your 4-digit OTP is: " + otp1);
    }

}
