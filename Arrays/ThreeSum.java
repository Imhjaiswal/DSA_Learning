package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    // BRUTEFORCE - T.C. - O(N**3) & S.C - 2*O(No of triplet)
    List<List<Integer>> bruteForce (int nums[]) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    if (nums[i]+nums[j]+nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();

                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        set.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // BETTER - 
    // T.C.- O(N**2 * log(No of unique triplet))
    // S.C.- O(N) + 2*O(No of unique triplet)
    List<List<Integer>> better (int nums[]) {
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;

        for (int i=0; i<n-1; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=i+1; j<n; j++) {
                int k = -(nums[i] + nums[j]);

                if (set.contains(k)) {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(k);

                    Collections.sort(triplets);
                    ans.add(triplets);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(ans);
    }

    // OPTIMAL
    // T.C. - O(N**2)
    // S.C. - O(1) , for returning all possible triplets O(No of unique triplets)
    List<List<Integer>> optimal (int nums[]) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i=0; i<n-2; i++) {
            // Skip duplicate first elements
            if (i>0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = n-1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    ans.add(triplet);
                    
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
}
