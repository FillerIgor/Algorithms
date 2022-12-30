package com.nocompany.hashtable;

import java.util.*;

public class FindAllAnagramsInString {

    public static void main(String[] args) {
        String s = "cbaebabacd";
//        String s = "abab";
        String p = "abc";
//        String p = "ab";

        List<Integer> result = findAnagramsMapsApproach(s, p);

        System.out.println("Result: " + result);

    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new LinkedList<>();
        int pLength = p.length();
        int sLength = s.length();

        if (pLength > sLength || pLength == 0) {
            return new LinkedList<>();
        }

        for (int i = 0; i <= sLength - pLength; i++) {
            if (isAnagram(s.substring(i, i + pLength), p)) {
                result.add(i);
            }
        }

        return result;
    }

    public static List<Integer> findAnagramsMapsApproach(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength || pLength == 0) {
            return new LinkedList<>();
        }

        List<Integer> result = new LinkedList<>();
        Map<Character, Integer> sSubMap = new HashMap<>(sLength);
        Map<Character, Integer> pMap = new HashMap<>(p.length());

        for (char pChar : p.toCharArray()) {
            pMap.put(pChar, pMap.getOrDefault(pChar, 0) + 1);
        }

        for (int i = 0; i < sLength; i++) {

            char iChar = s.charAt(i);
            sSubMap.put(iChar, sSubMap.getOrDefault(iChar, 0) + 1);


            if (i >= pLength) {
                iChar = s.charAt(i - pLength);
                if (sSubMap.get(iChar) == 1) {
                    sSubMap.remove(iChar);
                } else {
                    sSubMap.put(iChar, sSubMap.getOrDefault(iChar, 0) - 1);
                }

            }

            if (sSubMap.equals(pMap)) {
                result.add(i - pLength + 1);
            }
        }

        return result;
    }

    public static List<Integer> findAnagramsLeetCode(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns < np) return new ArrayList();

        Map<Character, Integer> pCount = new HashMap();
        Map<Character, Integer> sCount = new HashMap();
        // build reference hashmap using string p
        for (char ch : p.toCharArray()) {
            if (pCount.containsKey(ch)) {
                pCount.put(ch, pCount.get(ch) + 1);
            }
            else {
                pCount.put(ch, 1);
            }
        }

        List<Integer> output = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < ns; ++i) {
            // add one more letter
            // on the right side of the window
            char ch = s.charAt(i);
            if (sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch) + 1);
            }
            else {
                sCount.put(ch, 1);
            }
            // remove one letter
            // from the left side of the window
            if (i >= np) {
                ch = s.charAt(i - np);
                if (sCount.get(ch) == 1) {
                    sCount.remove(ch);
                }
                else {
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }
            // compare hashmap in the sliding window
            // with the reference hashmap
            if (pCount.equals(sCount)) {
                output.add(i - np + 1);
            }
        }
        return output;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int ctr : counter) {
            if (ctr != 0) {
                return false;
            }
        }
        return true;
    }
}
