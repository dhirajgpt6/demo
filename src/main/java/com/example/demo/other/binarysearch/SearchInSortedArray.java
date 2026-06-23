package com.example.demo.other.binarysearch;

public class SearchInSortedArray {
    public static void main(String[] args) {
        int [] input = {1,3,5,7,9};
        int target = 8;

        int left = 0;
        int right = input.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(input[mid]==target){
                System.out.println(mid);
                break;
            }

            if(input[mid] < target){ // 5<7
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }
        if (left < input.length){
            System.out.println(left);
        }
    }
}
