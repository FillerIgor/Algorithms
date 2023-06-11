package com.nocompany.sort;

public class LongestSubarrayAfterDeletingOneElement {

    public static void main(String[] args) {
//        int[] input = {0, 0, 1, 1, 0, 1};
        int[] input = {0,1,1,1,0,1,1,0,1};

        int result = longestSubarray(input);
        System.out.println("Result: " + result);
    }

    public static int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int start = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                zeroCount-=nums[start]==0?1:0;
                start++;
            }

            result = Math.max(result, i - start);
        }
        return result;
    }
}
