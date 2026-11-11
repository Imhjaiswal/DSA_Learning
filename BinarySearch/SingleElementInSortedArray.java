package BinarySearch;

public class SingleElementInSortedArray {
    // BRUTEFORCE
    // T.C. - O(N) & S.C. - O(1)
    int bruteForce (int nums[]) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;


        int n = nums.length;

        for (int i=1; i<n-1; i++) {
            if (nums[i] != nums[i+1] && nums[i-1] != nums[i]) {
                return nums[i];
            }
        }
        return nums[n-1];
    }

    // BETTER
    // T.C. - O(N/2) & S.C. - O(1)
    int better (int nums[]) {
        if (nums == null || nums.length == 0) return -1;

        for (int i=0; i<nums.length-1; i+=2) {
            if (nums[i] != nums[i+1]) return i;
        }
        return nums.length-1;
    }

    // OPTIMAL
    // T.C. - O(logN) & S.C. - O(1)
    int optimal (int nums[]) {
        if (nums == null || nums.length == 0) return -1;
        
        int n = nums.length;

        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n-1] != nums[n-2]) return nums[n-1];

        int s = 1;
        int e = n-2;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) return nums[mid];
            
            if ((mid % 2 == 0 && nums[mid] == nums[mid+1]) || 
            (mid % 2 != 1 && nums[mid-1] == nums[mid])) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return -1;
    }
}