package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum1 {
    List<Integer> subsetSum (int nums[]) {
        List<Integer> list = new ArrayList<>();

        generateSubsetSum(0, 0, nums, list);
        Collections.sort(list);
        
        return list;
    }

    void generateSubsetSum (int index, int sum, int nums[], List<Integer> list) {
        if (index == nums.length) {
            list.add(sum);
            return;
        }
        // TAKE
        generateSubsetSum(index+1, sum+nums[index], nums, list);
        // NOT TAKE
        generateSubsetSum(index+1, sum, nums, list);
    }
}
