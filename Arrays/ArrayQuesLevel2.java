package Arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ArrayQuesLevel2 {
    static int[] reverseArr (int arr[]) {
        int reversedArr[] = new int [arr.length];
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            reversedArr[start] = arr[end];
            reversedArr[end] = temp;
            start++;
            end--;
        }
        return reversedArr;
    }

    static void shiftBy1 (int arr []) {
        int end = arr.length;
        int temp = arr[end-1];

        for (int i = end-1; i > 0; i--) {
            arr[i] = arr[i];
        }

        arr[0] = temp;
    }

    // static void shiftByN(int arr[], int n) {
    //     int end = arr.length;
    //     n = n % end;

    //     for (int j = 0; j < n; j++) {
    //         int temp = arr[end - 1];

    //         for (int i = end - 1; i > 0; i--) {
    //             arr[i] = arr[i - 1];
    //         }

    //         arr[0] = temp;
    //     }
    // }

    static void getMode(int arr []) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = -1;
        int maxFreqKey = 0;
        for (int key : freq.keySet()) {
            int currentKey = key;
            int currentKeyFreq = freq.get(key);
            if (maxFreq < currentKeyFreq) {
                maxFreq = currentKeyFreq;
                maxFreqKey = currentKey;
            }
        }
        System.out.println(maxFreqKey +" : "+maxFreq);
    }

    static void getHighestAndLowest (int arr []) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int maxFreqKey = Integer.MIN_VALUE;
        for (int key : freq.keySet()) {
            int currentKey = key;
            int currentKeyFreq = freq.get(key);
            if (maxFreq < currentKey) {
                maxFreq = currentKeyFreq;
                maxFreqKey = currentKey;
            }
        }

        int minFreq = Integer.MAX_VALUE;
        int minFreqKey = Integer.MAX_VALUE;
        for (int key : freq.keySet()) {
            int currentKey = key;
            int currentKeyFreq = freq.get(key);
            if (minFreq > currentKey) {
                minFreq = currentKeyFreq;
                minFreqKey = currentKey;
            }
        }

        System.out.println("Number with highest frequency is "+maxFreqKey+" with frequency "+maxFreq);
        System.out.println("Number with lowest frequency is "+minFreqKey+" with frequency "+minFreq);
    }

    static Integer[] getUnion (Integer arr1[], Integer arr2[]) {
        LinkedHashSet<Integer> s1 = new LinkedHashSet<>(Arrays.asList(arr1));
        LinkedHashSet<Integer> s2 = new LinkedHashSet<>(Arrays.asList(arr2));
        s1.addAll(s2);

        return s1.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        // int arr [] = {2,4,6,8,10,12};
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(reverseArr(arr)));

        // int arr [] = {2,4,6,8,10,12};
        // shiftBy1(arr);
        // System.out.println(Arrays.toString(arr));

        // int arr [] = {2,4,6,8,10,12};
        // shiftByN(arr,2);

        // int arr[] = {1,2,1,5,4,5,5,4,3,3,1};
        // getMode(arr);
        // getHighestAndLowest(arr);

        Integer arr1[] = {1,2,3,4,5};
        Integer arr2[] = {3,4,5,6,7};
        System.out.println(Arrays.toString(getUnion(arr1, arr2)));
    }
}