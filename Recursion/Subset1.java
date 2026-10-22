package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset1 {
    List<List<Integer>> subsets (int nums[]) {
        List<List<Integer>> list = new ArrayList<>();

        generateSubset(0, nums, new ArrayList<>(), list);

        return list;
    }

    void generateSubset (int index, int nums[], List<Integer> current, List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }
        // TAKE
        current.add(nums[index]);
        generateSubset(index+1, nums, current, list);
        // BACKTRACK
        current.remove(current.size()-1);
        // NOT TAKE
        generateSubset(index+1, nums, current, list);
    }
}
