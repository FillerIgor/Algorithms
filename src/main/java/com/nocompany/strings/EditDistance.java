package com.nocompany.strings;

public class EditDistance {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        int result = minDistance(word1, word2);

        System.out.println("Result: " + result);
    }

    public static int minDistance(String word1, String word2) {
        return minDistanceRecur(word1, word2, word1.length(), word2.length());
    }

    public static int minDistanceRecur(String word1, String word2, int word1Index, int word2Index) {
        if (word1Index == 0) {
            return word2Index;
        }
        if (word2Index == 0) {
            return word1Index;
        }
        if (word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1)) {
            return minDistanceRecur(word1, word2, word1Index - 1, word2Index - 1);
        } else {
            int insertOperation = minDistanceRecur(word1, word2, word1Index, word2Index - 1);
            int deleteOperation = minDistanceRecur(word1, word2, word1Index - 1, word2Index);
            int replaceOperation = minDistanceRecur(word1, word2, word1Index - 1, word2Index - 1);
            return Math.min(insertOperation, Math.min(deleteOperation, replaceOperation)) + 1;
        }
    }
}
