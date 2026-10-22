package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StriversArray {
    int largestNum (int nums []) {
        int largest = nums[0];
        for (int i=0; i<nums.length; i++) {
            if (largest < nums[i]) {
                largest = nums[i];
            }
        }
        return largest;
    }

    int secondLargestNum (int nums []) {
        int largest = nums[0];
        int secondLargest = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (largest < nums[i]) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] < largest && nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }
        return secondLargest;
    }

    int SmallestNum (int nums []) {
        int smallest = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < smallest) {
                smallest = nums[i];
            }
        }

        return smallest;
    }

    int secondSmallestNum (int nums []) {
        int smallest = nums[0];
        int sSmallest = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] < smallest) {
                sSmallest = smallest;
                smallest = nums[i];
            } else if (nums[i] != smallest && nums[i] < sSmallest) {
                sSmallest = nums[i];
            }
        }
        return sSmallest;
    }

    boolean checkSortedArr (int arr []) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    int removeDuplicate (int arr []) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int i=0; i<arr.length; i++) {
            uniqueSet.add(arr[i]);
        }
        Integer[] newArr = uniqueSet.toArray(new Integer[0]);
        return newArr.length;
    }

    int removeDuplicateFromSortedArray (int arr []) {
        int i = 0;
        for (int j=1; j<arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;
            }
        }
        return (i+1);
    }

    int [] leftRotateArrBy1 (int arr []) {
        int n = arr.length;
        int temp = arr[0];

        for (int i=1; i<n; i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
        
         return arr;
    }

    int [] leftRotateArrByK (int arr [], int K) {
        int n = arr.length;
        if (K >= n) {
            K = K % n;
        }
        
        int temp [] = new int[K];
        for (int i=0; i<temp.length; i++) {
            temp[i] = arr[i];
        }

        for (int i=K; i<n; i++) {
            arr[i-K] = arr[i];
        }

        for (int i=n-K; i<n; i++) {
            arr[i] = temp[i-(n-K)];
        }

        return arr;
    }

    void reverseArr (int arr [], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }

    int [] leftRotateArrByKOptimal (int arr [], int K) {
        int n = arr.length;

        K = K % n;

        reverseArr(arr,0,K-1);
        reverseArr(arr, K, n-1);
        reverseArr(arr, 0, n-1);

        return arr;
    }

    int [] moveZerosToEnd (int arr[]) {
        int count = 1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 0) {
                count++;
            }
        }
        System.out.println(count);

        int temp [] = new int[count];
        int tempIndex = 0;
        for (int j=0; j<arr.length; j++) {
            if (arr[j] != 0) {
                temp[tempIndex] = arr[j];
                tempIndex++;
            }
        }

        for (int k=0; k<temp.length; k++) {
            arr[k] = temp[k];
        }

        for (int l=temp.length; l<arr.length; l++) {
            arr[l] = 0;
        }
        
        return arr;
    }

    void swap (int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    int [] moveZerosToEndOptimal (int arr []) {
        int j = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) return arr;

        for (int i=j; i<arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr[i],arr[j]);
                j++;
            }
        }

        return arr;
    }

    int linearSearch (int arr [], int num) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    int linearSearchRev (int arr [], int num) {
        for (int i=arr.length-1; i>=0; i--) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    int [] linearSearchAllOccurance (int arr [], int num) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
        }

        int temp [] = new int[count];
        int tempIndex = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == num) {
                temp[tempIndex] = i;
                tempIndex++;
            }
        }
        return temp;
    }

    Integer [] unionOfSortedArrays (int arr1[], int arr2[]) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : arr1) { 
            set.add(num);
        }

        for (int num : arr2) {
            set.add(num);
        }

        Integer [] unionArr = set.toArray(new Integer[0]);
        return unionArr;
    }

    Integer [] unionOfSortedArraysOptimal (int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;

        List<Integer> newArr = new ArrayList<>();

        while(i<n1 && j<n2) {
            if(arr1[i] <= arr2[j]) {
                if (newArr.isEmpty() || newArr.getLast() != arr1[i]) newArr.addLast(arr1[i]);
                i++;
            } 
            else {
                if (newArr.isEmpty() || newArr.getLast() != arr2[j]) newArr.addLast(arr2[j]);
                j++;
            }
        }

        while (j < n2) {
            if (newArr.isEmpty() || newArr.getLast() != arr2[j]) newArr.addLast(arr2[j]);
            j++;
        }

        while(i < n1) {
            if (newArr.isEmpty() || newArr.getLast() != arr1[i]) newArr.addLast(arr1[i]);
            i++;
        }

        Integer [] unionArray = newArr.toArray(new Integer[0]);
        return unionArray;
    }

    // Integer [] intersectionOfSortedArrays (int firstArr[], int secondArr[]) {
        
    // }
    boolean checkSorted(int nums[]) {
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                return false;
            }
        }
        return true;
    }
    

    int removeDuplicates (int nums[]) {
        if (nums.length == 0 || nums == null) return 0;

        int i=0;
        
        for (int j=1; j<nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
    
    void moveZeros (int nums[]) {
        List<Integer> temp = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) temp.add(nums[i]);
        }

        for (int i=0; i<temp.size(); i++) {
            nums[i] = temp.get(i);
        }

        int countZeros = nums.length - temp.size();

        if (countZeros > 0) {
            for (int i=temp.size(); i<nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    void moveZerosOptimal (int nums[]) {
        int j=-1;

        while (j<nums.length && nums[j]!=0) {
            j++;
        }

        if (j == -1) return;

        for (int i=j+1; i<nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    void swap (int nums[], int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    int[] unionSortedArray (int n1[], int n2[]) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int num: n1) set.add(num);

        for (int num: n2) set.add(num);

        int result[] = new int[set.size()];

        int i = 0;

        for (int num: set) {
            result[i++] = num;
        }

        return result;
    }

    int[] unionSortedArrayOptimal (int num1[], int num2[]) {
        List<Integer> list = new ArrayList<>();

        int i=0;
        int j=0;

        while (i<num1.length && j <num2.length) {
            int temp = -1;

            if (num1[i] == num2[j]) {
                temp = num1[i++];
                j++;
            } 
            else if (num1[i] < num2[j]) {
                temp = num1[i++];
            } 
            else {
                temp = num2[j++];
            }

            if (list.isEmpty() || list.get(list.size()-1) != temp) list.add(temp);
        }

        while (i<num1.length) {
            int temp = num1[i++];
            if (list.isEmpty() || list.get(list.size()-1) != temp) list.add(temp);
        }

        while (j<num2.length) {
            int temp = num2[i++];
            if (list.isEmpty() || list.get(list.size()-1) != temp) list.add(temp);
        }

        int result[] = new int[list.size()];
        for (int k=0; k<result.length; k++) {
            result[k] = list.get(k);
        }

        return result;
    }

    int[] intersectionSortedArrays (int n1[], int n2[]) {
        List<Integer> list = new ArrayList<>();
        boolean visited[] = new boolean[n2.length];

        for (int i=0; i<n1.length; i++) {
            for (int j=0; j<n2.length; j++) {

                if (n1[i] == n2[j] && !visited[j]) {
                    list.add(n1[i]);
                    visited[j] = true;
                    break;
                }

                if (n2[j] > n1[i]) break;
            }
        }

        int result[] = new int [list.size()];

        for (int k=0; k<result.length; k++) {
            result[k] = list.get(k);
        }

        return result;
    }

    int missingNum (int n, int nums[]) {
        int sum = n*(n+1)/2;

        for (int i=0; i<nums.length; i++) {
            sum -= nums[i];
        }

        return sum;
    }

    int missingNumOptimal (int n, int nums[]) {
        int sum = n;

        for (int i=0; i<nums.length; i++) {
            sum ^= i;
            sum ^= nums[i];
        }
        return sum;
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
        return maxCount;
    }

    int findUniqueNumBruteforce (int nums[]) {
        int n = nums.length;

        for (int i=0; i<n; i++) {
            int count = 0;
            int uNum = nums[i];

            for (int j=0; j<n; j++) {
                if (nums[j] == uNum) count++;

                if (count == 1) return uNum;
            }
        }
        return -1;
    }

    int findUniqueNum (int nums[]) {
        int uniqueNum = 0;

        for (int i=0; i<nums.length; i++) {
            uniqueNum ^= nums[i];
        }

        return uniqueNum;
    }

    
}