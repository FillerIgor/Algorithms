package com.nocompany.permutation;

import java.util.Arrays;

public class PermutationsStringSort {

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
        s1 = sort(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length()))))
                return true;
        }
        return false;
    }

    public static String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}
