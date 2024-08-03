package com.nocompany.strings;

public class IsPalindrome {
    public static void main(String[] args) {
        String input = "madam";

        boolean result = isPalindrome(input);
        System.out.println("Result: " + result + " for input: " + input);
    }

    public static boolean isPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;
        char[] inputArray = input.toCharArray();

        while (start <= end) {
            if (inputArray[start] == ' ') {
                start++;
                continue;
            }
            if (inputArray[end] == ' ') {
                end--;
                continue;
            }
            if (inputArray[start] != inputArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
