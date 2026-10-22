package BinarySearch;

public class SearchInRotatedSortedArray2 {
    boolean search (int nums[], int target) {
        int n = nums.length;

        if ((n == 1 && nums[0] != target) || n == 0) return false;

        if (n == 1 && nums[0] == target) return true;

        int start = 0;
        int end = n-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) return true;

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}