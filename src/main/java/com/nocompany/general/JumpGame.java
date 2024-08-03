package com.nocompany.general;

public class JumpGame {

    public static void main(String[] args) {
        //int[] input = {2, 3, 1, 1, 4};
        int[] input = {3,2,1,0,4}; //false
        boolean result = offSolution(input);
        System.out.println("Result: " + result);
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        boolean result = false;
        int lastIndex = nums.length - 1;
        int index = 0;

        while (index <= lastIndex) {
            int jumpLength = nums[index];
            int step = index + jumpLength;
            if (step == lastIndex) {
                return true;
            } else if (jumpLength == 0) {
                return false;
            }
            index = step;
        }

        return result;
    }

//    https://leetcode.com/problems/jump-game/solutions/5130181/video-move-goal-position
    public static boolean offSolution(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
