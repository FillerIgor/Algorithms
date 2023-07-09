package com.nocompany.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] input = {0,1,0,3,12};
        moveZeroes(input);

        System.out.println("Result " + Arrays.toString(input));
    }

    public static void moveZeroes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int num: nums){
            if(num!=0){
                result.add(num);
            }
        }

        while(result.size()!=nums.length){
            result.add(0);
        }

        for(int i = 0; i<nums.length;i++){
            nums[i]=result.get(i);
        }
    }

    public static void moveZeroesOfficial(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
