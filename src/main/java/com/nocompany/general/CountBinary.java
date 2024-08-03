package com.nocompany.general;

import java.util.*;
import java.util.stream.Collectors;

public class CountBinary {

    public static void main(String[] args) {
        int result = counting("10101");
        System.out.println(result);
    }

    static int counting(String s) {
        int result = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            char current = chars[i];
            char next = chars[j];

            if(current == next && (current != chars[i+2] && next != chars[j+2])) {
                result++;
                continue;
            }

            if(current !=next && (current != chars[i+1] && next != chars[j+1])){
                result++;
            }
        }
        return result;
    }

    public static List<String> funWithAnagrams(List<String> text) {
        List<String> sorted = text.stream().sorted().collect(Collectors.toList());
        List<String> result = new LinkedList<>();
        text.sort(String::compareTo);
        int j;
        for (int i = 0; i < text.size()-1; i++) {
            j= i+1;
            String current = text.get(i);
            char[] charArray = current.toCharArray();
            for (int i1 = 0; i1 < charArray.length; i1++) {

            }
            String next = text.get(j);
            while(j < text.size() && isAnagram(current, next)) {
                next = text.get(j);
                    j++;
            }
            i=j;
            result.add(current);
        }

        return result;
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
