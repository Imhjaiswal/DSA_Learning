package GreedyAlgorithm;

public class JumpGame {
    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1)
    boolean reachLast (int nums[]) {
        if (nums == null || nums.length == 0) return false;

        int maxPosition = 0;
 
        int n = nums.length;

        for (int i=0; i<n; i++) {
            // Current index cannot be reached
            if (i > maxPosition) return false;

            // Update farthest reachable position
            maxPosition = Math.max(maxPosition, i+ nums[i]);

            // if Last index is reachable
            if (maxPosition >= n-1) return true;
        }

        return true;
    }
}
