package com.nocompany.binarysearch;


/*
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * */
public class Search2DMatrix {

    public static void main(String[] args) {
        int target = 3;

        int[][] input = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        boolean result = searchMatrix(input, target);

        System.out.println("Result: " + result);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int lower = 0;
        int upper = rows * columns - 1;

        while (upper >= lower) {
            int mid = lower + (upper - lower) / 2;
            int midValue = matrix[mid / columns][mid % columns];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return false;
    }
}
