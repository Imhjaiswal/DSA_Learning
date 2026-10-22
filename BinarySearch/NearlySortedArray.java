package BinarySearch;

public class NearlySortedArray {
    int search (int nums[], int target) {
        int n = nums.length;

        if (n == 0) return -1;

        if (n == 1 && target == nums[n]) return n;

        int start = 0;
        int end = n-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (mid-1 >= start && nums[mid-1] == target) {
                return mid;
            }
            else if (mid+1 <= end && nums[mid+1] == target) {
                return mid;
            }

            if (target > nums[mid]) {
                start = mid + 2;
            } 
            else {
                end = mid - 2;
            }
        }
        return -1;
    }
}
