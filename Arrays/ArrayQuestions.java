package Arrays;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayQuestions {
    static double AvgArr (int arr []) {
        double sum = 0;
        for (int i : arr) { 
            sum += i;
        }
        double Avg = sum / arr.length ;
        return Avg;
    }

    static int[] MultiplyArrByN (int n, int arr[]) {
        int size = arr.length;
        int newArr [] = new int[size];

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int newElement = element * n;
            newArr[i] = newElement;
        }
        return newArr;
    }

    static int linearSearch (int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int getMaxVal (int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    static int getMinVal (int arr[]) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    static void SumOfNegAndPos (int arr []) {
        int size = arr.length;
        int posSum = 0;
        int negSum = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                negSum += arr[i];
            } else {
                posSum += arr[i];
            }
        }
        System.out.println("Sum of Positive numbers is: "+posSum+ " And sum of Negative numbers is: "+negSum);
    }

    static void zerosAndOnes (int arr[]) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if ( arr[i] == 1) {
                oneCount++;
            } else if (arr[i] == 0) {
                zeroCount++;
            }
        }
        System.out.println("Number of Zero & Ones in the array: "+Arrays.toString(arr)+" is "+zeroCount+" & "+oneCount);
    }

    static int getUnsortedElement (int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i+1] >= arr[i]) {
                continue;
            } else {
                return arr[i+1];
            }
        }
        return -1;
    }

    // SWAP Alternate elements in Array
    static int[] alternateSwap(int arr []) {
        int size = arr.length;

        for (int i = 0; i < size-1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        return arr;
    }

    static int[] intersectionArray (int arr[], int arr2[]) {
        // int [] result = new int[Math.min(arr.length, arr2.length)];
        // int k = 0;

        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j <arr2.length; j++) {
        //         if (arr[i] == arr2[j]) {
        //             result[k] = arr[i];
        //             k++;
        //         }
        //     }
        // }
        // return Arrays.copyOf(result, k);

        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        for (int num : arr) {
            map.put(num, 1);
        }

        for (int num : arr2) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }
        }

        int res [] = new int [Math.max(arr.length,arr2.length)];
        int index = 0;

        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                res[index++] = key;
            }
        }

        return Arrays.copyOf(res, index);
    }

    static int[] alternateExtremeSwap (int arr []) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int res [] = new int[n];
        
        for (int i=0; i<n; i+=2) {
            res[i] = arr[start++];

            if ((i+1) < n) {
                res[i+1] = arr[end--];
            }
        }

        return res;
    }

    int[] alternateExtremePair (int arr[]) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int res[] = new int [n];
        int i = 0;

        while (start <= end) {
            if (start == end) {
                res[n-1] = arr[start];
            } else {
                res[i] = arr[start];
                res[i+1] = arr[end];
                i += 2;
            }
            
            start++;
            end--;
        }
        return res;
    }

    static void main(String[] args) {
        // int arr1 [] = {2,4,6,8,11};
        // System.out.println(AvgArr(arr1));
        // System.out.println(Arrays.toString(MultiplyArrByN(5, arr1)));

        // LINEAR SEARCH
        // int arr [] = {16,2,4,19};
        // int target = 5;
        // int pos = linearSearch(arr, target);
        // if (pos == -1) {
        //     System.out.println(target+" is not present in array: "+Arrays.toString(arr));
        // } else {
        //     System.out.println(target+ " is at position "+ pos +" in the array: "+Arrays.toString(arr));
        // }

        // Maxnum
        // int arr [] = {100,10,20,55,70,101,150,90};
        // System.out.println(getMaxVal(arr));
        // System.out.println(getMinVal(arr));

        // Sum of Negative & Positive numbers 
        // int arr2 [] = {1,-2,3,-4,5,-6,7,-8,9,-10};
        // SumOfNegAndPos(arr2);

        // int arr[] = {0,1,0,1,0,10,0,1};
        // zerosAndOnes(arr);

        // Unsorted Element
        // int arr [] = {2,5,8,7,10,15};
        // System.out.println("Unsorted element in the arrays: "+Arrays.toString(arr)+" is "+getUnsortedElement(arr));

        // int arr[] = {1,2,3,4,5,6};
        // int newArr[] = {1,2,3,4,5,6};
        int arr1[] = {0,3,4,7,8,9};
        int arr2[] = {1,2,3,4,5,6,8};
        // System.out.println("Alternate Swap: "+Arrays.toString(alternateSwap(arr)));
        // System.out.println("Alternate Extreme Swap: "+Arrays.toString(alternateExtremeSwap(newArr)));
        System.out.println("Intersection Arrays: "+Arrays.toString(intersectionArray(arr1, arr2)));
    }   
}