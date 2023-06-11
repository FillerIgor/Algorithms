package com.nocompany.general;

import java.util.Arrays;

public class MaximizeDistanceClosestPerson {

    public static void main(String[] args) {

        int[] input = {1, 0, 0, 0, 1, 0, 1};

        int result = maxDistToClosest(input);

        System.out.println("Result: " + result);
    }

    public static int maxDistToClosestTwoPointers(int[] seats) {
        int ans = 0;
        int N = seats.length;
        int prev = -1;
        int future = 0;
        for (int i = 0; i< N; i++){
            if (seats[i]==1) {
                prev=i;
            }
            while(future<N && seats[future]==0 || future<i){
                future++;
            }

            int left = prev == -1 ? N : i - prev;
            int right = future == N ? N : future - i;
            ans = Math.max(ans, Math.min(left, right));
        }
        return ans;
    }

    public static int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i-1] + 1;
        }

        for (int i = N-1; i >= 0; --i) {
            if (seats[i] == 1) right[i] = 0;
            else if (i < N-1) right[i] = right[i+1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        return ans;
    }
}
