package com.nocompany.binarysearch;

/*
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * */
public class FindMinimumRotatedSortedArray {

    public static void main(String[] args) {

//        int[] input = new int[]{3, 4, 5, 1, 2};
//        int[] input = new int[]{4, 5, 1, 2, 3};
        int[] input = new int[]{3, 4, 5, 6, 7, 8, 9, 0, 1, 2};
//        int[] input = new int[]{3, 1};
        int result = findMin(input);
        System.out.println("Result: " + result);
    }

    public static int findMin(int[] nums) {
        int lower = 0;
        int upper = nums.length - 1;

        if (nums[lower] <= nums[upper] || nums.length == 1) {
            return nums[0];
        }

        while (lower <= upper) {
            int mid = lower + (upper - lower) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[mid] > nums[nums.length - 1]) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return -1;
    }
}
