package com.nocompany.hashtable;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(input);

        System.out.println("Result: " + result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dictionary = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> groupedValues = dictionary.get(key);

            if (groupedValues == null) {
                dictionary.put(key, new LinkedList<String>() {{
                    add(str);
                }});
            } else {
                groupedValues.add(str);
            }
        }
        return new LinkedList<>(dictionary.values());
    }

    public static List<List<String>> groupAnagramsNonOptimal(String[] strs) {

        LinkedList<String> temp = new LinkedList<>();
        Map<String, List<String>> dictionary = new HashMap<>();

        for (String str : strs) {
            dictionary.put(str, new LinkedList<String>() {{
                add(str);
            }});
        }

        for (String str : strs) {
            for (String key : dictionary.keySet()) {
                if (key.equals(str)) {
                    continue;
                }

                if (dictionary.get(str) != null && isAnagram(key, str)) {
                    List<String> keyValues = dictionary.get(str);
                    keyValues.add(key);
                    dictionary.put(str, keyValues);
                    temp.add(key);
                }
            }

            temp.forEach(dictionary::remove);
            temp.clear();
        }

        return new LinkedList<>(dictionary.values());
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
