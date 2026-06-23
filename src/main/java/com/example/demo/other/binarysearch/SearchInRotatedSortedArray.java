package com.example.demo.other.binarysearch;

//[4,5,6,7,0,1,2], target = 0
//Output: 4
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                System.out.println(mid);
                break;
            }
            if(nums[left]<=nums[mid]){
                if(nums[left] <= target && target<nums[mid]){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid-1;
                }
            }

        }
    }
}
