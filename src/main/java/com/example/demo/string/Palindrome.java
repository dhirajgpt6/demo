package com.example.demo.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Palindrome {
    public static void main(String[] args) {
        String input = "madamee";
        boolean isPalindrome = isPalindrome(input);
        System.out.println(isPalindrome);

        boolean canPalindrome = canPalindrome(input);
        System.out.println(canPalindrome);

    }

    private static boolean canPalindrome(String input) {
//        char[] charArray = input.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c: charArray){
//            map.put(c, map.getOrDefault(c,0)+1);
//        }

        Map<Character, Long> collect = input.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int count = 0;
        for (Long c: collect.values()) {
            if (c %2 !=0) {
                count++;
            }
        }
        if (count>1){
            return false;
        }
        return true;
    }

    private static boolean isPalindrome(String input) {
        int left=0;
        int right=input.length()-1;
        while(left<right){
            if(input.charAt(left) != input.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
