package com.nocompany.permutation;

import java.util.HashMap;

public class PermutationsStringHashMap {

    public static void main(String[] args) {
        String s1 = "ab";
//        String s1 = "adc";
//        String s1 = "prosperity";
//        String s2 = "eidbaooo";
        String s2 = "dcdba";
//        String s2 = "properties";

        boolean result = checkInclusion(s1, s2);

        System.out.println("Result: " + result);
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> s1map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++)
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> s2map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    public static boolean matches(HashMap<Character, Integer> s1map, HashMap<Character, Integer> s2map) {
        for (char key : s1map.keySet()) {
            if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0)
                return false;
        }
        return true;
    }

}
