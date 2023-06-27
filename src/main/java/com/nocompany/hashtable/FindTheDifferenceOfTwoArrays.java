package com.nocompany.hashtable;

import java.util.*;

public class FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3};
        int[] input2 = {2, 4, 6};

        List<List<Integer>> result = findDifference(input1, input2);

        System.out.println("Result: " + result);
    }

    // Returns the elements in the first arg nums1 that don't exist in the second arg nums2.
    public static List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2) {
        Set<Integer> onlyInNums1 = new HashSet<> ();

        // Store nums2 elements in an unordered set.
        Set<Integer> existsInNums2 = new HashSet<>();
        for (int num : nums2) {
            existsInNums2.add(num);
        }

        // Iterate over each element in the list nums1.
        for (int num : nums1) {
            if (!existsInNums2.contains(num)) {
                onlyInNums1.add(num);
            }
        }

        // Convert to vector.
        return new ArrayList<>(onlyInNums1);
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getElementsOnlyInFirstList(nums1, nums2), getElementsOnlyInFirstList(nums2, nums1));
    }
}
