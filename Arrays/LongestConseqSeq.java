package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConseqSeq {
    // BRUTEFORCE APPROACH
    // T.C. - O(N**2) & S.C - O(1)
    int bruteforce (int nums[]) {
        int longest = 0;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            int count = 1;
            int x = nums[i];
            while (linearSearch(nums, x+1)) {
                x += 1;
                count++;
            }
            longest = Math.max(count, longest);
        }

        return longest;
    }

    boolean linearSearch (int nums[], int x) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == x) {
                return true;
            }
        }
        return false;
    }

    // BETTER APPROACH
    // T.C - O(N * LOG N) & S.C. - O(1)
    int better (int nums[]) {
        int n = nums.length;

        if (n == 0) return 0;

        Arrays.sort(nums);

        int longest = 1;
        int count = 1;
        int lastSmaller = nums[0];

        for (int i=1; i<n; i++) {
            if (nums[i]-1 == lastSmaller) {
                count++;
                lastSmaller = nums[i];
            }
            else if (nums[i] != lastSmaller) {
                count = 1;
                lastSmaller = nums[i];
            }

            longest = Math.max(count, longest);
        }

        return longest;
    }

    // OPTIMAL APPROACH
    // T.C. O(2N) - & S.C. - O(N)
    int optimal (int nums[]) {
        int n = nums.length;
        int longest = 0;

        if (n == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for (int num: nums) set.add(num);

        for (int num: nums) {
            if (set.contains(num-1) == false) {
                int count = 1;
                int x = num;

                while (set.contains(x+1)) {
                    x++;
                    count++;
                }

                longest = Math.max(count, longest);
            }
        }

        return longest;
    }
}