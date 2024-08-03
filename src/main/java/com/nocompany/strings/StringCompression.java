package com.nocompany.strings;

public class StringCompression {

    public static void main(String[] args) {
//        char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
//        char[] input = {'a'};
//        char[] input = {'a', 'b', 'c'};

        int result = compress(input);
//        int result = compressLeetCode(input);
        System.out.println("Result: " + result);
    }

    public static int compress(char[] chars) {
        StringBuilder result = new StringBuilder();
        char currentChar;
        int j;
        int localCounter = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            j = i;
            currentChar = chars[i];
            while (j < chars.length - 1 && currentChar == chars[j + 1]) {
                j++;
                localCounter++;
            }
            result.append(currentChar);
            if (localCounter > 1) {
                result.append(localCounter);
            }
            i = j;
            localCounter = 1;
        }

        //leetcode requirement to copy. check results with the solution below
        char[] resultChars = result.toString().toCharArray();
        System.arraycopy(resultChars, 0, chars, 0, resultChars.length);
        return chars.length;
    }

    public static int compressLeetCode(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }
}
