package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    // BRUTEFORCE
    // T.C. - O(N * LOG N) + O(2N) --2N beacause we are not iterating over entire array for 
    // 1st element we only check until pair is under range and in 2nd loop we run it until end <= i+1 th element in array
    // S.C. - O(N)
    int[][] bruteForce (int intervals[][]) {
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for (int i=0; i<n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (merged.isEmpty() == false && end <= merged.get(merged.size()-1)[1]) {
                continue;
            }

            for (int j=i+1; j<n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            merged.add(new int[]{start,end});
        }
        return merged.toArray(new int[merged.size()][]);
    }

    // OPTIMAL
    // T.C. - O(N * LOG N) + O(N)
    // S.C. - O(N) 
    int[][] optimal (int intervals[][]) {
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        for (int i=0; i<n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (merged.isEmpty() == true || start > merged.get(merged.size()-1)[1]) {
                merged.add(new int[]{start,end});
            }
            else {
                merged.get(merged.size()-1)[1] = Math.max(end, merged.get(merged.size()-1)[1]);
            }
        }

        return merged.toArray(new int[merged.size()-1][]);
    }
}
