package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    List<List<Integer>> subsetsWithoutDuplicate (int nums[]) {
        List<List<Integer>> list = new ArrayList<>();  
        Arrays.sort(nums);
        
        generateSubset(0, nums, new ArrayList<>(), list);

        return list;
    }

    void generateSubset(int index, int nums[], List<Integer> current, List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }
        // TAKE
        current.add(nums[index]);
        generateSubset(index+1, nums, current, list);
        // BACKTRACK
        current.remove(current.size()-1);
        // SKIP DUPLICATE
        while (index+1 < nums.length && nums[index] == nums[index+1]) {
            index++;
        }
        // NOT TAKE
        generateSubset(index+1, nums, current, list);
    }

    void main () {
        int nums[] = {1,3,2,2};

        List<List<Integer>> subsets = subsetsWithoutDuplicate(nums);

        System.out.println(subsets);
    }
}
