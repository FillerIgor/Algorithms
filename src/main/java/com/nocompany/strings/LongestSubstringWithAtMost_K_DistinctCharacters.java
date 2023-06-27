package com.nocompany.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMost_K_DistinctCharacters {

    public static void main(String[] args) {

        String input = "eceba";
        int k = 2;

        int result = lengthOfLongestSubstringKDistinctTwoPointers(input, k);


    }

    public static int lengthOfLongestSubstringKDistinctTwoPointers(String s, int k) {
        int n = s.length();
        int maxSize = 0;
        Map<Character, Integer> counter = new HashMap<>();

        int left = 0;
        for (int right = 0; right < n; right++) {
            counter.put(s.charAt(right), counter.getOrDefault(s.charAt(right), 0) + 1);

            while (counter.size() > k) {
                counter.put(s.charAt(left), counter.get(s.charAt(left)) - 1);
                if (counter.get(s.charAt(left)) == 0) {
                    counter.remove(s.charAt(left));
                }
                left++;
            }

            maxSize = Math.max(maxSize, right - left + 1);
        }

        return maxSize;
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (k >= n) {
            return n;
        }

        int left = k, right = n;
        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (isValid(s, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static boolean isValid(String s, int size, int k) {
        int n = s.length();
        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        if (counter.size() <= k) {
            return true;
        }

        for (int i = size; i < n; i++) {
            char c1 = s.charAt(i);
            counter.put(c1, counter.getOrDefault(c1, 0) + 1);
            char c2 = s.charAt(i - size);
            counter.put(c2, counter.getOrDefault(c2, 0) - 1);
            if (counter.get(c2) == 0) {
                counter.remove(c2);
            }
            if (counter.size() <= k) {
                return true;
            }
        }

        return false;
    }
}
