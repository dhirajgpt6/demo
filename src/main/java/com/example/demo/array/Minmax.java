package com.example.demo.array;

import java.util.Arrays;

// Finding the minimum and maximum elements in an array
public class Minmax {
    public static void main(String[] args) {
        int[] A = { 4, 9, 6, 5, 2, 3 };
        System.out.println("Minimum element is: "
                + setmini(A));
        System.out.println("Maximum element is: "
                + setmaxi(A));

        //USING STREAM
        System.out.println("Minimum: " +Arrays.stream(A).min().getAsInt());
        System.out.println("Maximum: " +Arrays.stream(A).max().getAsInt());
    }

    public static int setmini(int[] A)
    {
        int mini = Integer.MAX_VALUE;
        System.out.println(mini);
        for (int i = 0; i < A.length; i++) {
            if (A[i] < mini) {
                mini = A[i];
            }
        }
        return mini;
    }

    public static int setmaxi(int[] A)
    {
        int maxi = Integer.MIN_VALUE;
        System.out.println(maxi);
        for (int i = 0; i < A.length; i++) {
            if (A[i] > maxi) {
                maxi = A[i];
            }
        }
        return maxi;
    }
}
