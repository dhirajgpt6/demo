package com.example.demo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 5}, {2, 8}, {10, 15}, {3, 7}, {20, 24}, {25, 30}, {22, 26}, {27, 29}
        };

        System.out.println("Original Intervals:" + Arrays.deepToString(intervals));
        int[][] merged = merge(intervals);
        System.out.println("modified Intervals:" + Arrays.deepToString(intervals));
        System.out.println("Merged Intervals:" + Arrays.deepToString(merged));

    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort by starting time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for (int[] interval : intervals) {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlap -> merge
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap -> add new interval
                current = interval;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
