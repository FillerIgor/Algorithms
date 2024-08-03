package com.nocompany.heapAndHash;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
//        int[] input = new int[]{1,1,1,2,2,3};
        int[] input = new int[]{4,1,-1,2,3,3,-1,2,3};
        int k = 2;

        int[] result = topKFrequent(input, k);

        System.out.println("Result: " + Arrays.toString(result));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int numbr : nums) {
            resultMap.put(numbr, resultMap.getOrDefault(numbr, 0) + 1);
        }

        int[] result = new int[k];
        Queue<Integer> queue = new PriorityQueue<>((a, b)->resultMap.get(a)-resultMap.get(b));
        for (Integer key : resultMap.keySet()) {
            queue.add(key);
            if (queue.size()>k){
                queue.poll();
            }
        }

        for (int i = k-1; i >= 0; i--) {
            result[i]=queue.poll();
        }

        return result;
    }
}
