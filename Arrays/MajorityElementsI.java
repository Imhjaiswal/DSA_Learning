package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementsI {
    // BRUTEFORCE
    int bruteforce (int nums[]) {
        int n = nums.length;

        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if (nums[i] == nums[j]) count++;
            }
            if (count > n/2) return nums[i];
        }
        return -1;
    }

    // BETTER
    int better (int nums[]) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if (count > n/2) return num;
        }
        return -1;
    }

    // OPTIMAL
    int optimal (int nums[]) {
        int element = 0;
        int count = 0;

        for (int num: nums) {
            if (count == 0) {
                element = num;
            }

            if (num == element) {
                count++;
            } 
            else {
                count--;
            }
        }

        return element;
    }
}
