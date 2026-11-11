package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class PeakElement {
    // BRUTEFORCE
    // T.C. - O(N) & S.C. - O(1)
    int bruteForceOneElement (int nums[]) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;

        if (n == 1) return nums[0];

        for (int i=0; i<n; i++) {
            if (i == 0 && nums[i] > nums[i+1]) return nums[i];
            if (i == n-1 && nums[i] > nums[i-1]) return  nums[i];

            if (i != 0 && i != n-1 && nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // T.C. - O(N) & S.C. - O(1)
    List<Integer> bruteForceAllPeaks (int nums[]) {
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) return list;

        int n = nums.length;

        for (int i=0; i<n; i++) {
            if (i == 0 && nums[i] > nums[i+1]) list.add(nums[i]);
            if (i == n-1 && nums[i] > nums[i-1]) list.add(nums[i]);

            if (i != 0 && i != n-1 && nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    // OPTIMAL
    // T.C. - & S.C. -
    int optimal (int nums[]) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;

        if (nums.length == 1) return nums[0];
        if (nums[0] > nums[1]) return nums[0];
        if (nums[n-1] > nums[n-2]) return nums[n-1];

        int s = 1;
        int e = n-2;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }

            if (nums[mid] > nums[mid-1]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
