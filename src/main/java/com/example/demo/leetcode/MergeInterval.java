package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {5, 7}, {6, 8}};
        int[][] mergedIntervals = merge(intervals);

        // Print the merged intervals
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }

        // Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= currentInterval[1]) { // Overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else { // Non-overlapping interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
