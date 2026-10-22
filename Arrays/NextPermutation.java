package Arrays;

import java.util.Arrays;

public class NextPermutation {
    // BRUTEFORCE
    void bruteForce (int nums[]) {
        // 1. Use Recursion to find all permutations

        // 2. Use linear search to find current num & return its next permutation

        // T.C. - O(N! * N)
        // O(N!) time for generating all permutation
        // O(N) time for processing & storing all permutation

        // S.C. - O(N! * N) for storing all permutations
    }

    // OPTIMAL
    int[] optimal (int nums[]) {
        int n = nums.length;
        int breakingPoint = -1;

        // FIND BREAKING POINT
        for (int i=n-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                breakingPoint = i;
                break;
            }
        }

        if (breakingPoint == -1) {
            reverse(nums, 0, n-1);
            return nums;
        }

        // FIND ELEMENT JUST GREATER THAN BREAKING_POINT
        for (int i=n-1; i>breakingPoint; i--) {
            if (nums[i] > nums[breakingPoint]) {
                swap(nums, breakingPoint, i);
                break;
            }
        }

        reverse(nums, breakingPoint+1, n-1);

        return nums;
    }

    void swap (int nums[], int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    void reverse (int nums[], int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
