package com.example.demo.other;

//Print a pattern with 1 star in one line 2 star in 2nd line and so on upto 5 rows
public class StarPrint {
    public static void main(String[] args) {
        int rows = 5;
        for (int i=0; i<rows; i++){
//            for (int j = rows-i; j>i; j--){
//                System.out.print("0");
//            }
            for(int j = 0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
