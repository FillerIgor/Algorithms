package com.nocompany.TwoPointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxArea(heights);

        System.out.println("Result: " + result);
    }

    public static int maxArea(int[] height) {

        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            int minBoarder = Math.min(height[left], height[right]);
            result = Math.max(minBoarder * (right-left), result);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
