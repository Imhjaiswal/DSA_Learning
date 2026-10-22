package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    List<List<Integer>> permute (int nums[]) {
        List<List<Integer>> list = new ArrayList<>();
        boolean freq[] = new boolean [nums.length];

        permuteRecursion(nums, new ArrayList<>(), list, freq);

        return list;
    }

    void permuteRecursion (int nums[], List<Integer> current, List<List<Integer>> list, boolean freq[]) {
        if (current.size() == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                current.add(nums[i]);
                permuteRecursion(nums, current, list, freq);
                current.remove(current.size()-1);
                freq[i] = false;
            }
        }
    }

    void permuteOptimal (int index, int nums[], List<List<Integer>> list) {
        if (index == nums.length) {
            List<Integer> current =  new ArrayList<>();

            for (int i=0; i<nums.length; i++) {
                current.add(nums[i]);
            }

            list.add(current);
            return ;
        }

        for (int i=0; i<nums.length; i++) {
            swap(nums, index, i);
            // ADD
            permuteOptimal(index+1, nums, list);
            // BACKTRACK
            swap(nums, index, i);
        }
    }

    void swap (int nums[], int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
