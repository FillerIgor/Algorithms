package com.nocompany.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervalsYandex {

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        /*int[][] input = new int[][]{
                {1, 3}
        };*/

        List<int[]> result = merge(input);

        System.out.println("Result:");
        result.forEach(ints -> System.out.println("\n" + Arrays.toString(ints)));
    }

    public static List<int[]> merge(int[][] input) {
        if (input==null || input.length==0){
            System.out.println("Input is null or empty");
            return List.of();
        }
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] ints : input) {
            if (result.isEmpty()) {
                result.add(ints);
            }
            int[] last = result.getLast();
            if (last[1] >= ints[0]) {
                last[1] = Math.max(last[1], ints[1]);
            } else {
                result.add(ints);
            }
        }
        return result;
    }
}
