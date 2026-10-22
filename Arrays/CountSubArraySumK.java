package Arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountSubArraySumK {
    // BRUTEFORCE
    int bruteforce (int nums[], int target) {
        int count = 0;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += nums[j];
                if (sum == target) count++;
                if (sum > target) break;
            }
        }
        return count;
    }

    // BETTER
    int better (int nums[], int target) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for (int num: nums) {
            prefixSum += num;

            int remaining = prefixSum - target;

            if (map.containsKey(remaining)) {
                count += map.get(remaining);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    // OPTIMAL
    // ONLY FOR POSITIVE NUMBERS
    int optimal (int nums[], int target) {
        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right=0; right<nums.length; right++) {
            sum += nums[right];

            while (left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }
            
            if (sum == target) {
                count++;
            }
        }
        return count;
    }
}
