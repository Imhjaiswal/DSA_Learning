package BinarySearch;

public class GetOccurances {
    // BRUTEFORCE
    // T.C. - O(N) & S.C. - O(1)
    int[] bruteForce (int nums[], int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};

        int n = nums.length;
        int lower = -1;
        int upper = -1;

        for (int i=0; i<nums.length; i++) {
            
            if (nums[i] >= target && lower == -1) lower = i;

            if (nums[i] > target) {
                upper = i;
                break;
            }
        }

        if (lower == -1 || nums[lower] != target) return new int[]{-1,-1};

        if (upper == -1) upper = n;

        return new int[]{lower, upper-1};
    }
    
    // OPTIMAL
    // T.C. - O(2*LogN) & S.C. - O(1)
    int[] optimal (int nums[], int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        
        int n = nums.length;

        int lower = getLowerBound(nums, target);
        if (lower == -1 || nums[lower] != target) return new int[]{-1,-1};
        
        int upper = getUpperBound(nums, target);

        if (upper == -1) upper = n;

        return new int[]{lower, upper-1};
    }

    int getLowerBound (int nums[], int target) {
        int n = nums.length;
        int s = 0;
        int e = n-1;
        int lower = -1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (nums[mid] >= target) {
                lower = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return lower;
    }

    int getUpperBound (int nums[], int target) {
        int n = nums.length;
        int s = 0;
        int e = n-1;
        int upper = -1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (nums[mid] > target) {
                upper = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return upper;
    }
}
