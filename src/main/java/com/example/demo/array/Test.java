package com.example.demo.array;
// find the number of occurance in array
public class Test {

    static int countOccurrences(int arr[], int x)
    {
        int result  = 0;
        for (int i=0; i<arr.length ; i++){
            if(arr[i] == x){
                result++;
            }
        }
        return result;
    }

    public static void main(String args[])
    {
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7 ,8 ,8 };
        int x = 2;
        System.out.println(countOccurrences(arr, x));
    }
}
