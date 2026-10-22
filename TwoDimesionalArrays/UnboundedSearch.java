package TwoDimesionalArrays;

public class UnboundedSearch {
    int search (int nums[], int target) {
        if (nums[0] == target) return 0;

        int i=1;
        while (nums[i] <= target) {
            i = i * 2;
        }

        if (nums[i] > target) {
            int start = i/2;
            int end = i;

            while (start <= end) {
                int mid = start + (end-start)/2;

                if (nums[mid] == target) {
                    return mid;
                }
                else if (target < nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}