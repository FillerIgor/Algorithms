package com.nocompany.sort;

import java.util.Arrays;

public class SquaresSortedArray {
    public static void main(String[] args) {
//        int[] input = new int[]{-4, -1, 0, 3, 10};
        int[] input = new int[]{-7,-3,2,3,11};
        int[] result = sortedSquares(input);
        System.out.println("Result: " + Arrays.toString(result));
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = nums.length-1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
