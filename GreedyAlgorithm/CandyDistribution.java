package GreedyAlgorithm;

import java.util.Arrays;

public class CandyDistribution {
    // BRUTEFORCE
    // T.C. - O(3N) => O(N) & S.C. - O(2N) => O(N)
    int[] distribute (int ratings[]) {
        if (ratings == null || ratings.length == 0) return new int[]{};

        if (ratings.length == 1) return new int[]{1};

        int n = ratings.length;
        int[]left = new int[n];
        int[]right = new int[n];

        left[0] = 1;
        right[n-1] = 1;

        // LEFT TO RIGHT
        for (int i=1; i<n; i++) {
            if (ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }

        // RIGHT TO LEFT
        for (int i=n-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                right[i] = right[i+1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int sum = 0;
        for (int i=0; i<n; i++) {
            right[i] = Math.max(right[i], left[i]);
            sum += right[i];
        }

        return right;
    }


    // BETTER
    // T.C. - O(2N) => O(N) & S.C. - O(N)
    int[] distribute2 (int ratings[]) {
        if (ratings == null || ratings.length == 0) return new int[]{};

        int n = ratings.length;
        int[]candies = new int[n];
        candies[0] = 1;

        // LEFT TO RIGHT
        for (int i=1; i<n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        // RIGHT TO LEFT
        int sum = candies[n-1];
        for (int i=n-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            sum += candies[i];
        }

        return candies;
    }

    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1)
    int optimal (int ratings[]) {
        if (ratings == null || ratings.length == 0) return 0;

        int n = ratings.length;
        int sum = 1;
        int i = 1;

        while(i < n) {
            if (ratings[i] == ratings[i-1]) {
                sum += 1;
                i++;
                continue;
            }

            int peak = 1;
            while (i<n && ratings[i] > ratings[i-1]) {
                peak++;
                sum += peak;
                i++;
            }

            int down = 1;
            while (i < n && ratings[i] < ratings[i-1]) {
                sum += down;
                down++;
                i++;
            }

            if (down > peak) {
                sum += down - peak;
            }
        }
        return sum;
    }
}
