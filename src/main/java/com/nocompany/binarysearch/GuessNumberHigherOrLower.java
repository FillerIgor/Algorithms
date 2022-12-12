package com.nocompany.binarysearch;

/*
 * Input: n = 10, pick = 6
 * Output: 6
 * */
public class GuessNumberHigherOrLower {

    static final int PICKED_NUMBER = 1;

    public static void main(String[] args) {

        int guess = 1;
//        int result = guessNumber(guess);
//        int result = guessNumberBinarySearch(guess);
        int result = guessNumberTernarySearch(guess);

        System.out.println("Result: " + result);
    }

    public static int guessNumber(int n) {
        for (int i = 1; i < n; i++) {
            if (checkNumber(i) == 0) {
                return i;
            }
        }
        return n;
    }

    public static int guessNumberBinarySearch(int n) {
        int lower = 1;
        int upper = n;

        while (lower <= upper) {
            int mid = lower + (upper - lower) / 2;
            int current = checkNumber(mid);
            if (current == 0) {
                return mid;
            } else if (current < 0) {
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return -1;
    }

    public static int guessNumberTernarySearch(int n) {
        int lower = 1;
        int upper = n;

        while (lower <= upper) {
            int mid1 = lower + (upper - lower) / 3;
            int mid2 = upper - (upper - lower) / 3;
            int current1 = checkNumber(mid1);
            if (current1 == 0){
                return mid1;
            }

            int current2 = checkNumber(mid2);
            if (current2 == 0){
                return mid2;
            }

            if (current1 < 0) {
                upper = mid1 - 1;
            } else if(current2 > 0) {
                lower = mid2 + 1;
            } else {
                lower = mid1 + 1;
                upper = mid2 -1;
            }
        }

        return -1;
    }

    public static int checkNumber(int n) {
        if (n > PICKED_NUMBER) {
            return -1;
        } else if (n < PICKED_NUMBER) {
            return 1;
        }
        return 0;
    }
}
