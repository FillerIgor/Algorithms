package com.nocompany.binarysearch;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] result = rotateMatrix(input);
        System.out.println("Result:\n " + Arrays.deepToString(result));

    }

    private static int[][] rotateMatrix(int[][] input) {
        int rowLength = input.length;
        int columnLength = input[0].length;
        //swap 1st and last
        for(int i=0;i<rowLength;i++){
            int temp = input[0][i];
            input[0][i] = input[columnLength-1][i];
            input[columnLength-1][i] = temp;
        }
        //transpose matrix
        for (int i=0;i<rowLength;i++){
            for (int j=i+1;j<columnLength;j++){
                int temp = input[j][i];
                input[j][i] = input[i][j];
                input[i][j] = temp;
            }
        }

        return input;
    }
}
