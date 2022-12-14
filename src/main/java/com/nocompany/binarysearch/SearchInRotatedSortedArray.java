package com.nocompany.binarysearch;

/*
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int target = 0;
        int[] input = {4, 5, 6, 7, 0, 1, 2};

        int result = search(input, target);
        System.out.println("Result: " + result);
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        //find rotationIndex - smallest element in array
        int rotationIndex = findRotationIndex(nums);

        if (nums[rotationIndex] == target) {
            return rotationIndex;
        }

        if (rotationIndex == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else if (nums[rotationIndex] <= target && nums[nums.length - 1] >= target) {
            return binarySearch(nums, rotationIndex, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, rotationIndex, target);
        }
    }

    public static int findRotationIndex(int[] nums) {
        int lower = 0;
        int upper = nums.length - 1;

        if (nums[lower] < nums[upper]) {
            return 0;
        }

        while (lower <= upper) {
            int currentMid = lower + (upper - lower) / 2;
            if (nums[currentMid] > nums[currentMid + 1]) {
                return currentMid + 1;
            } else if (nums[currentMid] < nums[lower]) {
                upper = currentMid - 1;
            } else {
                lower = currentMid + 1;
            }
        }
        return 0;
    }

    public static int binarySearch(int[] nums, int lower, int upper, int target) {
        while (lower <= upper) {
            int currentMid = lower + (upper - lower) / 2;
            if (nums[currentMid] == target) {
                return currentMid;
            } else if (nums[currentMid] < target) {
                lower = currentMid + 1;
            } else {
                upper = currentMid - 1;
            }
        }
        return -1;
    }
}
