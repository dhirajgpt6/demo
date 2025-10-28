package com.example.demo.string;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello";
        String reversedStr = reverseString(str);
        System.out.println("Reversed String: " + reversedStr);
    }

    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length(); i>0; i--) {
            System.out.println(str.charAt(i-1));
            reversed.append(str.charAt(i - 1));
        }
        return reversed.toString();
    }

}
