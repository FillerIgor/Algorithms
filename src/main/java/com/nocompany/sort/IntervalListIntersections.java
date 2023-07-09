package com.nocompany.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public static void main(String[] args) {
        int[][] firstList = {
                {0, 2},
                {5, 10},
                {13, 23},
                {24, 25}
        };
        int[][] secondList = {
                {1, 5},
                {8, 12},
                {15, 24},
                {25, 26}
        };
        List<int[]> result = intervalIntersection(firstList, secondList);

        System.out.println("Result:");
        result.forEach(ints -> System.out.println("\n" + Arrays.toString(ints)));
    }

    public static List<int[]> intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {

            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);

            if (lo <= hi) {
                result.add(new int[]{lo, hi});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
