package com.nocompany.hashtable;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
//        String s = "cat";
        String t = "nagaram";
//        String t = "car";

        boolean result = isAnagram(s, t);

        System.out.println("Result: " + result);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            dictionary.put(s.charAt(i), dictionary.getOrDefault(s.charAt(i), 0) + 1);
            dictionary.put(t.charAt(i), dictionary.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Integer counter : dictionary.values()) {
            if (counter != 0) {
                return false;
            }
        }
        return true;
    }
}
