package BinarySearch;

public class BookAllocation {
    int search (int nums[], int k) {
        int n = nums.length;
        if (n < 1 || k > n) return -1;

        int start = 0;
        int sum = 0;
        int ans = -1;

        for (int i=0; i<n; i++) {
            sum += nums[i];
            start = Math.max(start, nums[i]);
        }

        int end = sum;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (isValidAllocation(nums, k, mid)) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    boolean isValidAllocation (int nums[], int k, int maxPages) {
        int studentCount = 1;
        int pages = 0;

        for (int i=0; i<nums.length; i++) {
            if (pages + nums[i] <= maxPages) {
                pages += nums[i];
            }
            else {
                studentCount++;

                if (studentCount > k || nums[i] > maxPages) return false;

                pages = 0;
                pages += nums[i];
            }
        }
        return true;
    }

}
