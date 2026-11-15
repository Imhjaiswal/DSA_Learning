package GreedyAlgorithm;

import java.util.Arrays;

public class NonOverlappingIntervals {
    int removeOverlapping (int nums[][]) {
        if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length < 2) return 0;

        // SORT ACCORDING TO ENDTIME
        Arrays.sort(nums, (a,b) -> Integer.compare(a[1],b[1]));

        // GET No OF NON-OVERLAPPING INTERVALS
        int count = 1;
        int lastEndTime = nums[0][1];

        for (int i=1; i<nums.length; i++) {
            if (nums[i][0] >= lastEndTime) {
                count++;
                lastEndTime = nums[i][1];
            }
        }
        return nums.length-count;
    }
}
