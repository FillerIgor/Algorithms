package com.nocompany.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * */
public class TwoSum {
    public static void main(String[] args) {
//        int target = 9;
        int target = -8;
//        int[] input = new int[]{2, 7, 11, 15};
        int[] input = new int[]{-1, -2, -3, -4, -5};
        int[] result = twoSumHashMap(input, target);

        System.out.println("Result: " + Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                return new int[]{map.get(target - nums[i]), i};
            }

                map.put(nums[i], i);
        }

        return null;
    }
}
