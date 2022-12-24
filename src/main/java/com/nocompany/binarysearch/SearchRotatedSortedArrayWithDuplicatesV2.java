package com.nocompany.binarysearch;

public class SearchRotatedSortedArrayWithDuplicatesV2 {

    public static void main(String[] args) {

        int target = 1;
//        int[] input = new int[]{1,0,1,1,1};
//        int[] input = new int[]{1, 3};
//        int[] input = new int[]{3,3,0,1,3};
        int[] input = new int[]{2, 5, 6, 0, 0, 1, 2};
//        int[] input = new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        boolean isPresent = search(input, target);

        System.out.println("Result: number is present: " + isPresent);
    }

    private static boolean search(int[] nums, int target) {
        int lower = 0;
        int upper = nums.length - 1;

        while (lower <= upper) {
            int mid = lower + (upper - lower) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] == nums[lower]) {
                lower++;
                continue;
            }

            boolean isPivotInFirst = nums[lower] <= nums[mid];
            boolean isTargetInFirst = nums[lower] <= target;

            if (isPivotInFirst != isTargetInFirst) {
                if (isPivotInFirst) {
                    lower = mid + 1;
                } else {
                    upper = mid - 1;
                }
            } else {
                if (nums[mid] < target) {
                    lower = mid + 1;
                } else {
                    upper = mid - 1;
                }
            }
        }

        return false;
    }
}
