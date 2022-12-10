package com.nocompany.binarysearch;

/*
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
*/
public class BinarySearch {

    public static void main(String[] args) {
        int target = 9;
        int[] input = {-1, 0, 3, 5, 9, 12};
//        int result = search(input, target);
        //as soon as array is sorted it's possible to do prevalidation
        if (target<input[0] || target > input[input.length-1]){
            System.out.println("Result: -1");
            return;
        }
        int result = searchRecursive(input, target, 0, input.length);

        System.out.println("Result: " + result);
    }

    public static int search(int[] nums, int target) {
        int lower = 0;
        int upper = nums.length;

        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                lower = middle + 1;
            } else if (nums[middle] > target) {
                upper = middle - 1;
            }
        }
        return -1;
    }

    public static int searchRecursive(int[] nums, int target, int lower, int upper) {
        if (lower<0 || upper>nums.length || lower>upper) {
            return -1;
        }

        int middle = (lower + upper) / 2;
        if (nums[middle] == target) {
            return middle;
        }

        if (nums[middle] < target) {
            return searchRecursive(nums, target, middle + 1, upper);
        } else if (nums[middle] > target) {
            return searchRecursive(nums, target, lower, middle - 1);
        }

        return -1;
    }
}
