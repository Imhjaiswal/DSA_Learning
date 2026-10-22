package Recursion;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    List<List<Integer>> combinationSum (int nums[], int target) {
        List<List<Integer>> list = new ArrayList<>();

        generateCombination(0, nums, target, new ArrayList<>(), list);
        
        return list;
    }

    void generateCombination(int index, int nums[], int target, List<Integer> current, List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(current));
            return;
        }

        if (index == nums.length) return;

        if (nums[index] <= target) {
            // TAKE
            current.add(nums[index]);
            generateCombination(index, nums, target-nums[index], current, list);
            // BACKTRACK
            current.remove(current.size()-1);
        }
        // NOT TAKE
        generateCombination(index+1, nums, target, current, list);
    }
}