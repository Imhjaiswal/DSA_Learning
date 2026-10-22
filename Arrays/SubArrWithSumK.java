package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrWithSumK {
    // BRUTEFORCE
    int bruteForce (int nums[], int target) {
        int n = nums.length;
        int maxLen = 0;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; i++) {
                int sum = 0;
                for (int l=i; l<j; l++) {
                    sum += nums[l];
                    
                    if (sum == target) {
                        maxLen = Math.max(maxLen, j-i+1);
                    }

                    if (sum > target) break;
                }
            }
        }

        return maxLen;
    }

    // BRUTEFORCE-2
    int bruteForce2 (int nums[], int target) {
        int n = nums.length;
        int maxLen = 0;

        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; i++) {
                    sum += nums[j];
                    
                    if (sum == target) {
                        maxLen = Math.max(maxLen, j-i+1);
                    }

                    if (sum > target) break;
            }
        }

        return maxLen;
    }

    // BETTER
    int better (int nums[], int target) {
        Map<Long, Integer> map = new HashMap<>();

        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == target) maxLen = i + 1;

            Long rem = sum - target;

            if (map.containsKey(rem)) maxLen = Math.max(maxLen, i - map.get(rem));

            map.putIfAbsent(sum, i);
        }
        return maxLen;
    }

    // OPTIMAL
    int optimal (int nums[], int target) {
        int left = 0;
        long sum = 0;
        int maxLen = 0;

        for (int right=0; right<nums.length; right++) {
            sum += nums[right];

            while (left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }
            
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
