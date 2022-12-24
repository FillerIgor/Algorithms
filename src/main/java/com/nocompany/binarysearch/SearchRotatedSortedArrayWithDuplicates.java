package com.nocompany.binarysearch;


import java.util.Arrays;

/*
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * */
public class SearchRotatedSortedArrayWithDuplicates {

    public static void main(String[] args) {

        int target = 2;
//        int[] input = new int[]{2, 5, 6, 0, 0, 1, 2};
//        int[] input = new int[]{2, 2, 2, 3, 2, 2, 2};
//        int[] input = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
//        int[] input = new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
//        int[] input = new int[]{1, 2, 1};
        int[] input = new int[]{1, 1};
//        int[] input = new int[]{1, 3};
//        int[] input = new int[]{3,3,0,1,3};
        boolean isPresent = search(input, target);

        System.out.println("Result: number is present: " + isPresent);
    }

    public static boolean search(int[] nums, int target) {

        if(nums[0]==target || nums[nums.length-1]==target){
            return true;
        }

        nums = nums.length>1 ? shrinkArray(nums) : nums;
        int rotationIndex = findRotationIndex(nums);

        if(nums[rotationIndex] == target){
            return true;
        } else if (rotationIndex==0) {
            return binarySearch(nums, target, 0, nums.length - 1) != -1;
        } else if (nums[rotationIndex] < target && nums[nums.length - 1] >= target) {
            return binarySearch(nums, target, rotationIndex + 1, nums.length - 1) != -1;
        } else {
            return binarySearch(nums, target, 0, rotationIndex - 1) != -1;
        }

    }

    private static int[] shrinkArray(int[] nums) {
        int lower = 0;
        int upper = nums.length - 1;

        while (nums[lower] == nums[upper] && lower<upper) {
            lower++;
            upper--;
        }
        if (nums[lower]==nums[upper]){
            lower--;
        }
        return lower != 0 ? Arrays.copyOfRange(nums, lower, upper + 1) : nums;
    }

    public static int findRotationIndex(int[] nums) {
        int lower = 0;
        int upper = nums.length - 1;

        if (nums.length == 1) {
            return 0;
        }

        while (lower <= upper) {
            int mid = lower + (upper - lower) / 2;
            if (nums[mid + 1] < nums[mid]) {
                return mid + 1;
            } else if (nums[mid] > nums[nums.length - 1]) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return 0;
    }

    public static int binarySearch(int[] nums, int target, int lower, int upper) {
        int localLower = lower;
        int localUpper = upper;

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        while (localLower <= localUpper) {
            int mid = localLower + (localUpper - localLower) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] < target) {
                localLower = mid + 1;
            } else {
                localUpper = mid - 1;
            }
        }
        return -1;
    }
}
