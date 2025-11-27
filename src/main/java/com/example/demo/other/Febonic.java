package com.example.demo.other;

public class Febonic {
    public static void main(String[] args) {
        int len = 10;

        int pre = 0;
        int next = 1;
        System.out.print(pre + " " + next + " ");

        for (int i = 0; i<len; i++){
            int res = pre + next;
            System.out.print(res + " ");
            pre = next;
            next = res;
        }
    }
}
