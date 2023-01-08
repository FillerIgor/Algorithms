package com.nocompany.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] input = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] result = merge(input);

        System.out.println("Result: " + Arrays.deepToString(result));

    }

    public static int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] row: intervals){
            if (result.isEmpty()){
                result.add(row);
            } else {
                int[] last = result.getLast();
                if (last[1] >= row[0]) {
                    last[1] = Math.max(last[1],row[1]);
                } else {
                    result.add(row);
                };
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
