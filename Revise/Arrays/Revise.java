package Revise.Arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Revise {
    int linearSearch (int nums[], int target) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) return i+1;
        }
        return -1;
    }

    int largestNum (int nums[]) {
        int largest = Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }
        return largest;
    }

    int secondLargest (int nums[]) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            }
            else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) return -1;

        return secondLargest;
    }

    int maxConsecutiveOnes (int nums[]) {
        int count = 0;
        int maxCount = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }
        return  maxCount;
    }

    void rotateArrayBy1 (int nums[]) {
        if (nums == null || nums.length <= 1) return ;
        int temp = nums[0];

        for (int i=1; i<nums.length; i++) {
            nums[i-1] = nums[i];
        }
        nums[nums.length-1] = temp;
    }

    void moveZeros (int nums[]) {
        int n = nums.length;
        int j = 0;

        for (int i=0; i<n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }

    int removeDuplicates (int nums[]) {
        int j = 0;
        
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

    int[] removeDuplicatesArr (int nums[]) {
        int j = 0;
        
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return new int[]{0,j+1};
    }

    int findMissingNumber (int nums[]) {
        int num = nums.length;

        for (int i=0; i<nums.length; i++) {
            num = num ^ i;
            num = num ^ nums[i];
        }

        return num;
    }

    int[] unionSortedArr (int num1[], int num2[]) {
        Set<Integer> res = new LinkedHashSet<>();

        for (int num: num1) {
            res.add(num);
        }

        for (int num: num2) {
            res.add(num);
        }

        int ans[] = new int[res.size()];
        
        int j = 0;
        for (int num: res) {
            ans[j++] = num;
        }

        return ans;
    }

    int[] unionSortedArrOptimal (int num1[], int num2[]) {
        List<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != num1[i]) {
                    res.add(num1[i]);
                }
                i++;
            }
            else if (num2[j] < num1[i]) {
                if (res.isEmpty() || res.get(res.size()-1) != num2[j]) {
                    res.add(num2[j]);
                }
            }
            else {
                if (res.isEmpty() || res.get(res.size()-1) != num1[i]) {
                    res.add(num1[i]);
                }
                i++;
                j++;
            }
        }

        while (i < num1.length) {
            if (res.isEmpty() || res.get(res.size()-1) != num1[i]) {
                res.add(num1[i]);
            }
            i++;
        }

        while (j < num2.length) {
            if (res.isEmpty() || res.get(res.size()-1) != num2[j]) {
                res.add(num2[j]);
            }
            j++;
        }

        int ans[] = new int [res.size()];

        for (int k=0; k<res.size(); k++) {
            ans[k] = res.get(k);
        }

        return  ans;
    }

    int[] interesctionSortedArr (int num1[], int num2[]) {
        Map<Integer, Integer> res = new LinkedHashMap<>();

        for (int num: num1) {
            res.put(num, res.getOrDefault(num,0) + 1);
        }

        for (int num: num2) {
            res.put(num, res.getOrDefault(num,0) + 1);
        }

        int count = 0;
        for (int key: res.keySet()) {
            if (res.get(key) > 1) {
                count++;
            }
        }

        int ans[] = new int [count];
        int j = 0;

        for (int key: res.keySet()) {
            if (res.get(key) > 1) {
                ans[j++] = key;
            }
        }

        return ans;
    }

    int[] interesctionSortedArrOptimal (int num1[], int num2[]) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                i++;
            } 
            else if (num2[j] < num1[i]) {
                j++;
            }
            else {
                if (res.isEmpty() || res.get(res.size()-1) != num1[i]) {
                    res.add(num1[i]);
                }
                i++;
                j++;
            }
        }

        int ans[] = new int[res.size()];

        for (int k=0; k<res.size(); k++) {
            ans[k] = res.get(k);
        }

        return ans;
    }

    int majorityElement (int nums[]) {
        int n = nums.length;

        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if (nums[i] == nums[j]) count++;
            }

            if (count > n/2) return nums[i];
        }
        return -1;
    }

    int majorityElementBetter (int nums[]) {
        Map<Integer, Integer> res = new LinkedHashMap<>();

        int n = nums.length;

        for (int num: nums) {
            res.put(num, res.getOrDefault(num, 0) + 1);

            if (res.get(num) > n/2) return num;
        }
        return -1;
    }

    int majorityElementOptimal (int nums[]) {
        Map<Integer, Integer> res = new LinkedHashMap<>();

        for (int num: nums) {
            res.put(num, res.getOrDefault(num, 0)+1);

            if (res.get(num) > nums.length/2) return num;
        }
        return -1;
    }

    List<Integer> spiralMatrix (int mat[][]) {
        List<Integer> res = new ArrayList<>();
        
        int left = 0;
        int right = mat[0].length-1;
        int top = 0;
        int bottom = mat.length-1;

        while (left <= right && top <= bottom) {
            // LEFT -> RIGHT
            for (int row=left; row<=right; row++) {
                res.add(mat[top][row]);
            }
            top++;
            // TOP -> BOTTOM
            for (int col=top; col<=bottom; col++) {
                res.add(mat[col][right]);
            }
            right--;
            // RIGHT -> LEFT
            if (top <= bottom) {
                for (int row=right; row>=left; row--) {
                    res.add(mat[bottom][row]);
                }
                bottom--;
            }
            // BOTTOM -> TOP
            if (left <= right) {
                for (int col=bottom; col>=top; col--) {
                    res.add(mat[col][left]);
                }
                left++;
            }
        }
        return res;
    }

    List<Integer> sumOfRow (int mat[][]) {
        List<Integer> res = new ArrayList<>();

        for (int row=0; row<mat[0].length; row++) {
            int sum = 0;
            for (int col=0; col<mat.length; col++) {
                sum += mat[row][col];
            }
            res.add(sum);
        }
        return res;
    }

    List<Integer> sumOfEachCol (int mat[][]) {
        List<Integer> result = new ArrayList<>();

        for (int col=0; col<mat[0].length; col++) {
            int sum = 0;
            for (int row=0; row<mat.length; row++) {
                sum += mat[row][col];
            }
            result.add(sum);
        }
        return result;
    }

    List<Integer> waveMatrix (int mat[][]) {
        List<Integer> res = new ArrayList<>();

        for (int col=0; col<mat[0].length; col++) {
            if ((col%2 == 0)) {
                for (int row=0; row<mat.length; row++) {
                    res.add(mat[row][col]);
                }
            } else {
                for (int row=mat[0].length-1; row>=0; row--) {
                    res.add(mat[row][col]);
                }
            }
        }
        return res;
    }

    int[][] TransposeMatrix (int mat[][]) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return new int[0][0];

        int transpose[][] = new int[mat[0].length][mat.length];

        for (int row=0; row<mat.length; row++) {
            for (int col=0; col<mat[0].length; col++) {
                transpose[col][row] = mat[row][col];
            }
        }

        return transpose;
    }

    void rotateBy90Degrees (int mat[][], int N) {
        for (int row=0; row<N; row++) {
            for (int col=0; col<N; col++) {
                int temp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = temp;
            }
        }

        for (int row=0; row<N; row++) {
            int startCol = 0;
            int endCol = N-1;

            while (startCol <= endCol) {
                int temp = mat[row][startCol];
                mat[row][startCol] = mat[row][endCol];
                mat[row][endCol] = temp;

                startCol++;
                endCol--;
            }
        }
    }

    List<Integer> leadersInArray (int nums[]) {
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            boolean leader = true;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] < nums[j]) {
                    leader = false;
                    break;
                }
            }
            if (leader == true) ans.add(nums[i]);
        }
        return ans;
    }

    List<Integer> leadersInArrayOptimal (int nums[]) {
        List<Integer> ans = new ArrayList<>();
        int maxElement = Integer.MIN_VALUE;

        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] > maxElement) ans.add(nums[i]);

            maxElement = Math.max(maxElement, nums[i]);
        }

        Collections.sort(ans, Collections.reverseOrder());

        return ans;
    }

    void setMatrixZero (int mat[][]) {
        int rowLen = mat.length;
        int colLen = mat[0].length;

        int[]row = new int [rowLen];
        int[]col = new int [colLen];

        for (int i=0; i<rowLen; i++) {
            for (int j=0; j<colLen; j++) {
                if (mat[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i=0; i<rowLen; i++) {
            for (int j=0; j<colLen; j++) {
                if (row[i]==1 || col[j]==1) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    void setMatrixZeroOptimal (int matrix[][]) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int col0 = 1;

        for (int i=0; i<rowLen; i++) {
            for (int j=0; j<colLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i=0; i<rowLen; i++) {
            for (int j=0; j<colLen; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j=0; j<colLen; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i=0; i<colLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    int[] rearrangeArr (int nums[]) {
        int n = nums.length;

        int pos [] = new int [n/2];
        int neg [] = new int [n/2];

        int posIndex = 0;
        int negIndex = 0;

        for (int i=0; i<n; i++) {
            if (nums[i] > 0) {
                pos[posIndex] = nums[i];
                posIndex++;
            }
            else {
                neg[negIndex] = nums[i];
                negIndex++;
            }
        }

        for (int i=0; i<n/2; i++) {
            nums[2 * i] = pos[i];
            nums[2 * i + 1] = neg[i];
        }
        return nums;
    }

    int[] rearrangeArrOptimalSol (int nums[]) {
        int n = nums.length;

        int posIndex = 0;
        int negIndex = 1;

        int ans[] = new int[n];

        for (int i=0; i<n; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } 
            else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return ans;
    }

    // FOR UNEQUAL NUMBER OF POS & NEG ELEMENTS
    int[] rearrangeArrNewCase (int nums[]) {
        int n = nums.length;

        int pos[] = new int[n];
        int neg[] = new int[n];

        int posIndex = 0;
        int negIndex = 0;

        for (int i=0; i<n; i++) {
            if (nums[i] > 0) {
                pos[posIndex++] = nums[i];
            }
            else {
                neg[negIndex++] = nums[i];
            }
        }

        int index = 0;
        int i = 0;
        int j = 0;

        while (i<posIndex && j<negIndex) {
            nums[index++] = pos[i++];
            nums[index++] = neg[j++];
        }

        while (i<posIndex) {
            nums[index++] = pos[i++];
        }

        while (j<negIndex) {
            nums[index++] = neg[j++];
        }

        return nums;
    }
}