package com.example.demo.leetcode;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {

//        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;

//        int[] nums2 = {2, 5, 6};
        int[] nums2 = {1, 2, 3};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println("Merged Array:");
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int index = nums1.length - 1;
       while (pointer2 >=0) {
           if(pointer1>=0 && nums1[pointer1] > nums2[pointer2]){
                nums1[index] = nums1[pointer1];
                pointer1--;
           } else {
               nums1[index] = nums2[pointer2];
               pointer2--;
           }
           index--;
       }
    }
}
