package Recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> combinationSum (int nums[], int target) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        generateCombination(0, nums, target, list, new ArrayList<>());

        return list;
    }

    void generateCombination(int index, int nums[], int target, List<List<Integer>> list, List<Integer> current) {
        if (target == 0) {
            list.add(new ArrayList<>(current));
            return ;
        }

        for (int i=index; i<nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) continue;
            if (nums[i] > target) break;
            // TAKE
            current.add(nums[i]);
            generateCombination(i+1, nums, target-nums[i], list, current);
            // BACKTRACK
            current.remove(current.size()-1);
        }
    }
}