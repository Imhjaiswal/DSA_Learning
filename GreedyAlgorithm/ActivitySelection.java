package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivitySelection {
    // OPTIMAL - Returning possible Activities
    // T.C. - O(N) & S.C. - O(1) -- excluding output list
    List<List<Integer>> optimal (int[]start, int[]end) {
        List<List<Integer>> result = new ArrayList<>();

        if (start == null || end == null || start.length == 0 ||  end.length == 0) {
            return result;
        }

        result.add(Arrays.asList(start[0], end[0]));
        int prevEnd = end[0];

        for (int i=1; i<start.length; i++) {
            if (start[i] >= prevEnd) {
                result.add(Arrays.asList(start[i], end[i]));
                prevEnd = end[i];
            }
        }
        
        return result;
    }

    // OPTIMAL - For counting activities
    // T.C. - O(N) & S.C. - O(1) -- excluding output list
    int optimal2 (int[]start, int[]end) {
        if (start == null || end == null || start.length == 0 ||  end.length == 0) {
            return 0;
        }

        int maxAct = 1;
        int prevEnd = end[0];

        for (int i=1; i<start.length; i++) {
            if (start[i] >= prevEnd) {
                maxAct++;
                prevEnd = end[i];
            }
        }
        
        return maxAct;
    }
}
