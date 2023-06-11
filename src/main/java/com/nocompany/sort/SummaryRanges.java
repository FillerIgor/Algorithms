package com.nocompany.sort;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        int[] input = {0, 1, 2, 4, 5, 7};
        List<String> result = summaryRanges(input);
        System.out.println("Result: " + result);

    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length-1 && nums[j + 1] - nums[j] == 1) {
                ++j;
            }
            String interval = nums[i] == nums[j] ? String.valueOf(nums[i]) :
                    nums[i] + "->" + nums[j];
            result.add(interval);
            i = j;
        }
        return result;
    }
}
