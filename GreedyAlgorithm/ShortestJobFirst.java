package GreedyAlgorithm;

import java.util.Arrays;

public class ShortestJobFirst {
    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1)
    int avgTime (int jobs[]) {
        if (jobs == null || jobs.length == 0) return 0;

        Arrays.sort(jobs);

        int waitingTime = 0;
        int totalWaitingTime = 0;

        for (int i=0; i<jobs.length; i++) {
            totalWaitingTime += waitingTime;
            waitingTime += jobs[i];
        }

        return totalWaitingTime/jobs.length;
    }
}
