package BinarySearch;

public class HowManyTimeArrayIsRotated {
    // BRUTEFORCE
    // T.C. - O(N) & S.C. - O(1)
    int bruteforce (int nums[]) {
        if (nums == null || nums.length == 0) return 0;

        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return i+1;
            }
        }
        return 0;
    }

    // OPTIMAL
    // T.C. - O(LogN) & S.C. - O(1)
    int optimal (int nums[]) {
        if (nums == null || nums.length == 0) return -1;

        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;

        int n = nums.length;
        int s = 0;
        int e = n-1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (nums[s] <= nums[e]) {
                if (nums[s] < minVal) {
                    minVal = nums[s];
                    minIndex = s;
                }
                break;
            }

            if (nums[s] <= nums[mid]) {
                if (nums[s] < minVal) {
                    minVal = nums[s];
                    minIndex = s;
                }
                s = mid + 1;
            } 
            else {
                if (nums[mid] < minVal) {
                    minVal = nums[mid];
                    minIndex = mid;
                }
                e = mid - 1;
            }
        }
        return minIndex;
    }
}
