package BinarySearch;

public class MinimumInRotatedSortedArray {
    // BRUTEFORCE
    // T.C. - O(N) & S.C. - O()
    int bruteForce (int nums[]) {
        if (nums == null || nums.length == 0) return -1;

        int minVal = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {
            minVal = Math.min(minVal, nums[i]);
        }
        return minVal;
    }

    // OPTIMAL
    // T.C. - O() & S.C. - O()
    int optimal (int nums[]) {
        if (nums == null || nums.length == 0) return -1;

        int minVal = Integer.MAX_VALUE;
        int s = 0;
        int e = nums.length-1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            // THIS IS CONDITION IS FOR DUPLICATE VALUES ONLY
            if (nums[s] == nums[mid] && nums[mid] == nums[e]) {
                minVal = Math.min(minVal, nums[s]);
                s++;
                e--;
                continue;
            }

            if (nums[s] <= nums[e]) {
                minVal = Math.min(minVal, nums[s]);
                break;
            }

            if (nums[s] <= nums[mid]) {
                minVal = Math.min(minVal, nums[s]);
                s = mid + 1;
            } else {
                minVal = Math.min(minVal, nums[mid]);
                e = mid - 1;
            }
        }
        return minVal;
    }
}
