package BinarySearch;

public class SingleNonDuplicateNumber {
    int search (int nums[]) {
        int n = nums.length;

        if (n == 0) return -1;
        if (n == 1) return nums[0];

        int start = 0;
        int end = n-1;

        while (start < end) {
            int mid = start + (end-start)/2;

            if (mid%2 == 1) mid--;

            if ((mid+1)<=end && nums[mid] == nums[mid+1]) {
                start = mid + 2;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}