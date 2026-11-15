package GreedyAlgorithm;

import java.util.Arrays;

public class MinNoPlatformRequiredInRailwayStation {
    // BRUTEFORCE
    // T.C. - O(N**2) & S.C. - O(1)
    int requiredPlatform (int arrival[], int departure[]) {
        if (arrival == null || departure == null || arrival.length == 0 || departure.length == 0 || arrival.length != departure.length) {
            return 0;
        }

        int platforms = 0;
        int n = arrival.length;

        for (int i=0; i<n; i++) {
            int count = 1;
            for (int j=0; j<n; j++) {
                if (arrival[j] <= arrival[i] && departure[j] >= arrival[i]) count++;
            }
            platforms = Math.max(platforms, count);
        }
        return platforms;
    }

    // OPTIMAL
    // T.C. - O(2*NlogN) + O(N) & S.C. - O(1)
    int requiredPlatformOptimal (int arrival[], int departure[]) {
        if (arrival == null || departure == null || arrival.length != departure.length || 
            arrival.length == 0 || departure.length == 0) {
            return 0;
        }

        Arrays.sort(arrival);
        Arrays.sort(departure);
        int noOfPlatforms = 0;
        int count = 0;
        int n = arrival.length;
        int a = 0;
        int d = 0;

        while (a < n) {
            if (arrival[a] <= departure[d]) {
                count++;
                a++;
            } else {
                count--;
                d++;
            }

            noOfPlatforms = Math.max(count, noOfPlatforms);
        }
        return noOfPlatforms;
    }
}