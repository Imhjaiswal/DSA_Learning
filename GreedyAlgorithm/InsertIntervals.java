package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    // GREEDY APPROACH
    // T.C. - O(N) & S.C. - O(N)
    int[][] insertNewInterval (int nums[][], int[]newInterval) {
        if (newInterval == null ||newInterval.length < 2) return new int[0][];

        if (nums == null || nums.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }

        List<int[]> result = new ArrayList<>();

        int n = nums.length;
        int i = 0;

        // LEFT NON-OVERLAPPING PART
        while (i < n && nums[i][1] < newInterval[0]) {
            result.add(nums[i]);
            i++;
        }

        // OVERLAPPING PART PART
        while (i < n && nums[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], nums[i][0]);
            newInterval[1] = Math.max(newInterval[1], nums[i][1]);
            i++;
        }
        result.add(new int[]{newInterval[0], newInterval[1]});

        // RIGHT NON-OVERLAPPING PART
        while (i < n) {
            result.add(new int[]{nums[i][0], nums[i][1]});
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
