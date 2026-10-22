package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ArrayQues4 {
    List<List<Integer>> threeSum (int [] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    if (nums[i]+nums[j]+nums[k] == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    List<List<Integer>> twoSum (int arr[], int target) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<n-1; i++) {
            int j = i+1;
            while (j < n) {
                if (arr[i]+arr[j] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    res.add(temp);
                }
                j++;
            }
        }
        return res;
    }

    int[] removeduplicateElementsSortedArr (int nums[]) {
        int i = 0;
        int n = nums.length;
        for (int j=1; j<n; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return Arrays.copyOf(nums, i+1);
    }

    int firstRepetitingElementSortedArray (int nums[]) {
        int i = 0;
        for (int j=1; j<nums.length; j++) {
            if (nums[i] == nums[j]) {
                return nums[j];
            } else {
                i++;
            }
        }
        return -1;
    }

    int firstRepetitingElementUnsortedArray (int nums[]) {
        // BRUTE FORCE APPROACH :
        // for (int i=0; i<nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         if (nums[j] == nums[i]) {
        //             return nums[i]; 
        //         }
        //     }
        // }
        // return -1;

        // OPTIMAL APPROACH :
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for (int i : nums) {
            if (map.get(i) > 1) {
                return i;
            }
        }
        return -1;
    }

    int pivotIndex (int nums[]) {
        // BRUTE FORCE APPROACH:
        // int n = nums.length;
        // for (int i=0; i<n; i++) {
        //     int leftSum = 0;
        //     int rightSum = 0;

        //     for (int j=0; j<i; j++) {
        //         leftSum += nums[j];
        //     }

        //     for (int j=i+1; j<n; j++) {
        //         rightSum += nums[j];
        //     }

        //     if (leftSum == rightSum) {
        //         return i;
        //     }
        // }
        // return -1;

        // OPTIMAL APPROACH:
        int n = nums.length;
        int leftSum[] = new int[n];
        int rightSum[] = new int[n];

        leftSum[0] = nums[0];
        for (int i=1; i<n; i++) {
            leftSum[i] = leftSum[i-1] + nums[i];
        }

        rightSum[n-1] = nums[n-1];
        for (int i=n-2; i>=0; i--) {
            rightSum[i] = rightSum[i+1] + nums[i];
        }

        System.out.println(Arrays.toString(leftSum));
        System.out.println(Arrays.toString(rightSum));

        for (int j=0; j<n; j++) {
            if (leftSum[j] == rightSum[j]) {
                return j;
            }
        }
        return -1;
    }

    void main () {
        // int arr[] = {-1,0,1,2,-1,-4};
        // System.out.println(threeSum(arr, 0));

        // int arr[] = {1,2,2,3,3,4,5};
        // System.out.println(duplicateElements(arr));
        // System.out.println(Arrays.toString(arr));
        // System.out.println(firstRepetitingElementSortedArray(arr));

        // int arr[] = {10,5,3,4,3,5,6};
        // int arr2[] = {5,2,4,6,7,4,10};
        // System.out.println(firstRepetitingElementUnsortedArray(arr));
        // System.out.println(firstRepetitingElementUnsortedArray(arr2));

        // int arr[] = {1,7,3,6,5,6};
        // int arr2[] = {2,1,-1};
        // int arr3[] = {1,2,3};
        // System.out.println("Pivot number is at index "+pivotIndex(arr));
        // System.out.println();
        // System.out.println("Pivot number is at index "+pivotIndex(arr2));
        // System.out.println();
        // System.out.println("Pivot number is at index "+pivotIndex(arr3));

        // int arr[] = {-1,-2,-3,-4,-5};
        // System.out.println(twoSum(arr, -5));
        // System.out.println(twoSum(arr, -8));
        // System.out.println(twoSum(arr, -4));

        String s1 = "abc"; 
        String s2 = "abc";
        System.out.println("S1 == S2: " + s1.equals(s2));
    }
}