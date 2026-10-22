package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    // BRUTEFORCE
    // FOR INT[]
    int[] bruteForce (int nums[], int target) {
        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
    // FOR BOOLEAN
    Boolean bruteForce2 (int nums[], int target) {
        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // BETTER - Optimal for Unsorted Arrays
    // FOR INT[]
    int[] better (int nums[], int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int remNum = target - nums[i];

            if (map.containsKey(remNum)) {
                return new int[]{map.get(remNum),i};
            }

            map.put(nums[i],i);
        }
        return new int[]{};
    }
    // FOR BOOLEAN
    Boolean better2 (int nums[], int target) {
        Set <Integer> set = new HashSet<>();

        for (int i=0; i<nums.length; i++) {
            int remNum = target - nums[i];

            if (set.contains(remNum)) {
                return true;
            }
        }
        return false;
    }

    // OPTIMAL ONLY FOR SORTED ARRAYS
    int[] optimal (int nums[], int target) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left, right};
            }
            else if (nums[left] + nums[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return new int[]{};
    }

    boolean optimal2 (int nums[], int target) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return true;
            }
            else if (nums[left] + nums[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return false;
    }
}