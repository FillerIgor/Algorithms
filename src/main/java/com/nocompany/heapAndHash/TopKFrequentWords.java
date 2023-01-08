package com.nocompany.heapAndHash;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
//        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        String[] words = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 2;

        List<String> result = topKFrequent(words, k);

        System.out.println("Result: " + result);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> result = new LinkedList<>();
        Queue<String> queue = new PriorityQueue<>((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));
        for (String word : map.keySet()) {
            queue.add(word);
            if (queue.size()>k){
                queue.poll();
            }
        }

        while (!queue.isEmpty()){
            result.add(queue.poll());
        }

        Collections.reverse(result);
        return result;
    }
}
