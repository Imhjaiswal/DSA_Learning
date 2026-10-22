package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    // BRUTEFORCE - 
    // T.C. - O(N**4 * NLOG(N)) 
    // S.C. - O(2*M) , M -- no of unique Quadruples
    List<List<Integer>> bruteForce (int nums[], int target) {
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;

        for (int i=0; i<n-3; i++) {
            for (int j=i+1; j<n-2; j++) {
                for (int k=j+1; k<n-1; k++) {
                    for (int l=k+1; l<n; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                        if (sum == target) {
                            List<Integer> quadruple = new ArrayList<>();
                            quadruple.add(nums[i]);
                            quadruple.add(nums[j]);
                            quadruple.add(nums[k]);
                            quadruple.add(nums[l]);

                            Collections.sort(quadruple);

                            ans.add(quadruple);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    // BETTER
    // T.C. - O(N**3)
    // S.C. - O(N + M) , O(N) FOR STORING VALUE INTO SET , M - NO. OF UNIQUE QUADRUPLES
    List<List<Integer>> better (int nums[], int target) {
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;

        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k=j+1; k<n; k++) {
                    int l = target - nums[i] - nums[j] - nums[k];

                    if (set.contains(l)) {
                        List<Integer> quadruple = new ArrayList<>();
                        quadruple.add(nums[i]);
                        quadruple.add(nums[j]);
                        quadruple.add(nums[k]);
                        quadruple.add(l);

                        Collections.sort(quadruple);

                        ans.add(quadruple);
                    }
                    set.add(nums[k]);
                }
            }
        }

        return new ArrayList<>(ans);
    }

    // OPTIMAL 
    // T.C. - O(N**3 + N*LOG(N)) -> O(N**3) AS ITS DOMINANT
    // S.C. - O(M) -- M is no of Unique Quadruples
    List<List<Integer>> optimal (int nums[], int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i=0; i<n-1; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j=i+1; j<n; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;

                int k = j+1;
                int l = n-1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k-1]) k++;
                        while (k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}
