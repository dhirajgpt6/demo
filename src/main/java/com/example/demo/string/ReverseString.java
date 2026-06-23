package com.example.demo.string;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello";
        String reversedStr = reverseString(str);
        System.out.println("Reversed String: " + reversedStr);

        String reversedStr2 = reverseString2(str);
        System.out.println("Reversed String: " + reversedStr2);
    }

    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length(); i>0; i--) {
            reversed.append(str.charAt(i - 1));
        }
        return reversed.toString();
    }
    static String reverseString2(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = str.length()-1;
        while (start < end) {
            System.out.println();
            char temp = charArray[start];
            charArray[start] = str.charAt(end);
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }
}
