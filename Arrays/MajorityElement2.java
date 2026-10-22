package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    // T.C. - O(N**2) & S.C. - O(1) not O(N)as elements appearing more than n/3 will be always 2
    List<Integer> bruteforce (int nums[]) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int min = n/3;

        for (int i=0; i<n; i++) {
            if (list.contains(nums[i])) continue;
            int count = 0;

            for (int j=0; j<n; j++) {
                if (nums[i] == nums[j]) count++;
            }

            if (count > min) list.add(nums[i]);
        }
        return list;
    }

    // T.C. - O(N) & S.C. - O(N) not O(2N)as elements appearing more than n/3 will be always 2
    List<Integer> better (int nums[]) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int min = n/3;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            int count = map.getOrDefault(nums[i],0)+1;
            map.put(nums[i],count);

            if (list.contains(nums[i])) continue;

            if (count > min) list.add(nums[i]);
        }
        return list;
    }

    // T.C. - O(N) & S.C. - O(1) not O(N)as elements appearing more than n/3 will be always 2
    List<Integer> optimal (int nums[]) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int min = n/3;

        int el1 = -1;
        int count1 = 0;
        int el2 = -1;
        int count2 = 0;

        for (int i=0; i<n; i++) {
            if (count1 == 0 && nums[i] != el2) {
                el1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0 && nums[i] != el1) {
                el2 = nums[i];
                count2 = 1;
            }
            else if (nums[i] == el1) {
                count1++;
            }
            else if (nums[i] == el2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num: nums) {
            if (el1 == num) count1++;
            if (el2 == num) count2++;
        }

        if (count1 > min) list.add(el1);
        if (count2 > min && el2 != el1) list.add(el2);

        return list;
    }
}
