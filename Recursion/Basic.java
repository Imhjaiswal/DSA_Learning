package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Basic {
    void printName (int limit, int count) {
        if (count > limit) return;

        System.out.println("Harsh");
        printName(limit, count+1);
    }

    void printNums (int Limit, int num) {
        if (num == Limit) return;

        System.out.println(num);
        printNums(Limit, num+1);
    }

    void printNumsRev (int num) {
        if (num < 1) return;

        System.out.println(num);
        printNumsRev(num-1);
    }

    void printNumsBackTrack (int num, int Limit) {
        if (num < 1) return ;

        printNumsBackTrack(num-1, Limit);
        System.out.println(num);
    }

    void printNumsRevBackTrack (int num, int Limit) {
        if (num > Limit) return ;

        printNumsRevBackTrack(num+1, Limit);
        System.out.println(num);
    }

    // PARAMETERIZED RECURSION:
    void sumOfN (int N, int sum) {
        if (N < 1) {
            System.out.println(sum);
            return ;
        }

        sumOfN(N-1, sum+N);
    }

    // FUNCTIONAL RECURSION:
    int sumOfNnums (int N) {
        if (N == 0) return 0;

        return N + sumOfNnums(N-1);
    }

    void factorialOfN (int N, int fact) {
        if (N < 1) {
            System.out.println(fact);
            return ;
        }

        factorialOfN(N-1, fact * N);
    }

    int factorialOfNnums (int N) {
        if (N == 0) return 1;

        return N * factorialOfNnums(N-1);
    }

    void reverseArr (int arr[], int start, int end) {
        if (start >= end) return;

        Swap(arr, start, end);

        reverseArr(arr, start+1, end-1);
    }

    void Swap (int arr[], int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    void revArr (int arr[], int i) {
        int n = arr.length;
        if (i >= n/2) return;

        Swap(arr, i, n-i-1);
        i++;

        revArr(arr, i);
    }

    boolean checkPalindrome (String str, int i) {
        int n = str.length();
        
        if (i >= n/2) return true;
        
        if (str.charAt(i) != str.charAt(n-1-i)) {
            return false;
        }

        return checkPalindrome(str, i+1);
    }

    // MULTIPLE RECURSION CALLS -
    int Fibonacci (int n) {
        if (n <= 1) return n;

        int last = Fibonacci(n-1);
        int secondLast = Fibonacci(n-2);

        return last + secondLast;
    }

    // SUB-SEQUENCE RECURSION CALLS -
    void subSequence (int index, int arr[], ArrayList<Integer> list) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }

        list.add(arr[index]);

        subSequence(index+1, arr, list);

        list.remove(list.size()-1);

        subSequence(index+1, arr, list);
    }

    // STORING ALL SUB-SEQUENCES
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        generateSubsets (0, nums, current, list);
        return list;
    }

    void generateSubsets (int index, int nums[], ArrayList<Integer> current, List<List<Integer>> list) {
        if (index >= nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);

        generateSubsets(index+1, nums, current, list);

        current.remove(current.size()-1);

        generateSubsets(index+1, nums, current, list);
    }

    // SUB-SEQUENCE WITH SUMMATION K -
    void subSequenceWithSumK (int index, int nums[], ArrayList<Integer> list, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                System.out.println(list);
            }
            return;
        }

        // TAKE
        list.add(nums[index]);
        sum += nums[index];

        subSequenceWithSumK(index+1, nums, list, sum, target);

        // BACKTRACK
        list.remove(nums[index]);
        sum -= nums[index];

        // NOT TAKE
        subSequenceWithSumK(index+1, nums, list, sum, target);
    }

    // ONLY ONE SUB-SEQUENCE WITH SUMMATION K -
    boolean oneSubSequenceWithSumK (int index, int nums[], int target, int sum, ArrayList<Integer> list) {
        if (index == nums.length) {
            if (sum == target) {
                System.out.println(list);
                return true;
            } else {
                return false;
            }
        }

        // TAKE
        list.add(nums[index]);
        sum += nums[index];

        if (oneSubSequenceWithSumK(index+1, nums, target, sum, list)) return true;

        // BACKTRACK
        list.remove(list.size()-1);
        sum -= nums[index];

        // NOT TAKE
        if (oneSubSequenceWithSumK(index+1, nums, target, sum, list)) return true;

        return false;
    }

    int subSequenceWithSumKCount (int index, int nums[],int sum, int target) {
        if (sum > target) return 0;
        
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        // TAKE
        sum += nums[index];
        int l = subSequenceWithSumKCount(index+1, nums, sum, target);

        // BACKTRACK
        sum -= nums[index];

        // NOT TAKE
        int r = subSequenceWithSumKCount(index+1, nums, sum, target);
        
        return l + r;
    }
}