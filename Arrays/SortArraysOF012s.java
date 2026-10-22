package Arrays;

public class SortArraysOF012s {
    // BRUTEFORCE
    void bruteForce (int nums[]) {
        // USING MERGESORT OR QUICKSORT WHICH WILL GIVE T.C. of O(N * log N)
    }

    // BETTER
    // T.C. - O(2N) & S.C. - O(1)
    void better (int nums[]) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int n = nums.length;

        for (int num: nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        // 0
        for (int i=0; i<count0; i++) {
            nums[i] = 0;
        }
        // 1
        for (int i=count0; i<count0+count1; i++) {
            nums[i] = 1;
        }
        // 2
        for (int i=count0+count1; i<n; i++) {
            nums[i] = 2;
        }
    }

    // OPTIMAL
    void optimal (int nums[]) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n-1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap (nums, low, mid);
            } 
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    void swap (int nums[], int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
