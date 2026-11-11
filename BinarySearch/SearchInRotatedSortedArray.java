package BinarySearch;

public class SearchInRotatedSortedArray {
    // BRUTEFORCE
    // USING LINEAR SEARCH
    // T.C. - O(N) & O(1)
    

    // OPTIMAL
    // T.C. - O(LogN) & S.C. - O(1)
    int optimal (int nums[], int target) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int s = 0;
        int e = n-1;
        
        while (s <= e) {
            int mid = s + (e-s)/2;

            if (nums[mid] == target) return mid;

            if (nums[s] <= nums[mid]) {
                if (nums[s] <= target && target <= nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }

        }
        return -1;
    }
}