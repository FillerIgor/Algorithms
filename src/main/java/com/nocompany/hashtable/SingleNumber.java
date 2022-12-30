package com.nocompany.hashtable;

import java.util.HashMap;
import java.util.Map;

/*
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * */
public class SingleNumber {

    public static void main(String[] args) {
        int[] input = new int[]{4, 1, 2, 1, 2};

        int result = singleNumberXOR(input);
        System.out.println("Result: " + result);
    }

    public static int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int counter = map.get(num) != null ? map.get(num) + 1 : 1;
            map.put(num, counter);
        }

        for (int num : nums) {
            Integer counter = map.get(num);
            if (counter == 1) {
                return num;
            }
        }

        return 0;
    }


    //todo IMPORTANT
    //a⊕a=0
    //a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
    public static int singleNumberXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }
}
