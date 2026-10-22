package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    List<Integer> bruteforce (int nums[]) {
        List<Integer> leaders = new ArrayList<>();
        int n = nums.length;

        for (int i=0; i<n; i++) {
            boolean isLeader = true;
            for (int j=i; j<n; j++) {
                if (nums[j] > nums[i]) {
                    isLeader = false;
                }
            }
            if (isLeader) {
                leaders.add(nums[i]);
            }
        }
        return leaders;
    }

    List<Integer> optimal (int nums[]) {
        List<Integer> leaders = new ArrayList<>();
        
        int n = nums.length;
        int maxVal = nums[n-1];
        leaders.add(maxVal);

        for (int i=n-2; i>=0; i--) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                leaders.add(nums[i]);
            }
        }

        int start = 0;
        int end = leaders.size()-1;

        while (start < end) {
            int temp = leaders.get(start);
            leaders.set(start, leaders.get(end));
            leaders.set(end, temp);

            start++;
            end--;
        }

        return leaders;
    }
}
