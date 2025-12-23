package com.example.demo.number;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Find the smallest (least) missing positive number
//input: {-9, 0, 2, 1, 1, 3, 5, 6}
//output: 4
public class FindMissingNumber {
    // -------------------------------
    // 1️⃣ Swap / Index Placement (O(1) space) ⭐⭐⭐⭐⭐
    // -------------------------------
    public static int firstMissingPositiveSwap(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n
                    && nums[nums[i] - 1] != nums[i]) {

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // -------------------------------
    // 2️⃣ HashSet + while (O(n) space) ⭐⭐⭐
    // -------------------------------
    public static int firstMissingPositiveSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        int missing = 1;
        while (true) {
            if (!set.contains(missing)) {
                return missing;
            }
            missing++;
        }
    }

    // -------------------------------
    // 3️⃣ Stream + range (O(n) space) ⭐⭐⭐⭐
    // -------------------------------
    public static int firstMissingPositiveStream(int[] nums) {

        Set<Integer> set = Arrays.stream(nums)
                .filter(x -> x > 0)
                .boxed()
                .collect(Collectors.toSet());
        IntStream.rangeClosed(1, set.size() + 1).forEach(System.out::println);
        return IntStream.rangeClosed(1, set.size())
                .filter(i -> !set.contains(i))
                .findFirst()
                .orElse(set.size() + 78);
    }

    // -------------------------------
    // MAIN METHOD
    // -------------------------------
    public static void main(String[] args) {

        int[] input = {-9, 0, 2, 1, 1, 4,3, 5, 6};

        // IMPORTANT: swap method modifies array, so copy needed
        System.out.println("Swap-Index Placement  : "
                + firstMissingPositiveSwap(Arrays.copyOf(input, input.length)));

        System.out.println("HashSet + while         : "
                + firstMissingPositiveSet(input));

        System.out.println("Stream + range          : "
                + firstMissingPositiveStream(input));
    }
}
