package GreedyAlgorithm;

public class JumpGame2 {
    // T.C. - O(N) & S.C. - O(1)
    int reachLast (int nums[]) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int jumps = 0;
        int l = 0;
        int r = 0;

        while (r < n-1) {
            int farthest = 0;

            for (int i=l; i<=r; i++) {
                farthest = Math.max(i+nums[i], farthest);
            }

            if (farthest <= r) return -1;

            l = r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}
