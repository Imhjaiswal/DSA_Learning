package GreedyAlgorithm;

import java.util.Arrays;

public class JobSequencing {
    // OPTIMAL
    // T.C. - O(N logN) + O(N) + O(N * D)
    // S.C. - O(D) 
    // -- D is no of maxDeadline day
    int[] jobSequencing (Job[] jobs) {
        if (jobs == null || jobs.length == 0) return new int[]{0,0};

        // SORT ARRAYS
        Arrays.sort(jobs, (a,b) -> Integer.compare(b.profit, a.profit));

        // FIND MAX DEADLINE
        int maxDeadline = 0;
        for (Job job: jobs) {
            maxDeadline = Math.max(job.deadline, maxDeadline);
        }

        // INITIALIZE SLOTS ARRAY ACCORDING TO DEADLINE
        int slots[] = new int[maxDeadline+1];
        Arrays.fill(slots, -1);

        int jobCount = 0;
        int maxProfit = 0;
        // Job Scheduling
        for (Job job: jobs) {
            for (int i=jobs.length; i>=0; i--) {
                if (slots[i] == -1) {
                    slots[i] = job.id;
                    jobCount++;
                    maxProfit += job.profit;
                }
            }
        }

        return new int[]{jobCount, maxProfit};
    }
}


class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}