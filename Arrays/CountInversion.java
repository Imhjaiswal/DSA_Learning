package Arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversion {
    // BRUTEFORCE
    // T.C. - O(N**2)
    // S.C. - O(M) -- M no of inversion pairs
    List<List<Integer>> bruteforce (int nums[]) {
        List<List<Integer>> inversion = new ArrayList<>();
        int n = nums.length;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] > nums[j]) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[i]);
                    pair.add(nums[j]);
                    inversion.add(pair);
                }
            }
        }
        return inversion;
    }
    // COUNT INVERSIONS
    // T.C. - O(N**2)
    // S.C. - O(1)
    int bruteforceCount (int nums[]) {
        int n = nums.length;
        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // OPTIMAL
    // T.C. -
    // S.C. -
    int optimalCount (int nums[]) {
        int n = nums.length;
        int count = 0;

        return count++;
    }
}
