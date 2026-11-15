package GreedyAlgorithm;

import java.util.Arrays;

public class AssignCookies {
    // Optimal
    // T.C. - O(N*logN) + O(M*logM) + O(N+M)
    // S.C. - O(1)
    int assignCookies (int[]greed, int[]cookies) {
        if (greed == null || cookies == null) return 0;

        Arrays.sort(greed);
        Arrays.sort(cookies);

        int child = 0;
        
        for (int i=0; i<cookies.length && child < greed.length; i++) {
            if (greed[child] <= cookies[i]) {
                child++;
            }
        }

        return child;
    }
}
