package BinarySearch;

public class PaintersPartition {
    int search (int nums[], int totalPainters) {
        int n = nums.length;

        if (n == 0) return 0;

        int start = 0;
        int end = 0;
        int ans = 0;

        for (int i=0; i<n; i++) {
            end += nums[i];
            start = Math.max(start, nums[i]);
        }

        if (n == 1) return end;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (isPaintingDone(nums, totalPainters, mid)) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    boolean isPaintingDone (int arr[], int totalPainters, int maxTime) {
        int painterNo = 1;
        int time = 0;

        for (int i=0; i<arr.length; i++) {
            if (time + arr[i] <= maxTime) {
                time += arr[i];
            }
            else {
                painterNo++;

                if (painterNo > totalPainters || arr[i] > maxTime) return false;
                time = arr[i];
            }
        }
        return true;
    }
}
