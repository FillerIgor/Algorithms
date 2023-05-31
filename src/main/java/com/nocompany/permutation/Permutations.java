package com.nocompany.permutation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        List<List<Integer>> result = permutate(numbers);

        System.out.println("Result: " + result);
    }

    public static List<List<Integer>> permutate(int[] numbers) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> numList = new LinkedList<>();
        for (int n : numbers) {
            numList.add(n);
        }
        backtrack(numList, result, 0);
        return result;
    }

    public static void backtrack(List<Integer> numbers, List<List<Integer>> result, int firstIndex) {
        if (firstIndex == numbers.size() - 1) {
            result.add(new LinkedList<>(numbers));
        }
        for (int i = firstIndex; i < numbers.size(); i++) {
            Collections.swap(numbers, firstIndex, i);
            backtrack(numbers, result, firstIndex + 1);
            Collections.swap(numbers, firstIndex, i);
        }
    }


}
