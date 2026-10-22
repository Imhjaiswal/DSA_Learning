package Arrays;
import java.util.*;

class ArrayDS {
    // static void main (String [] args)        {
    //     int arr[] = {11,22,33,44,55};
    //     int arr2[] = {4,-10,19,2,16};
    //     int sum = 0;
    //     int muliplication = 1;
    //     int maxNum = arr2[0];
    //     int minNum = arr2[0];

    //     for (int i = 0; i < arr.length; i++) {
    //         sum += arr[i];
    //     }
    //     System.out.println("Sum of arr is:  "+sum);

    //     for (int i = 0; i < arr.length; i++) {
    //         muliplication *= arr[i];
    //     }
    //     System.out.println("Muliplication of arr is:  "+muliplication);

    //     for (int i = 0; i < arr2.length; i++) {
    //         if (arr2[i] > maxNum) {
    //             maxNum = arr2[i];
    //         }
    //     }
    //     System.out.println("Largest number in the arr2 is: "+maxNum);

    //     for (int i = 0; i < arr2.length; i++) {
    //         if (arr2[i] < minNum) {
    //             minNum = arr2[i];
    //         }
    //     }
    //     System.out.println("Smallest number in the arr2 is: "+minNum);
    // }

    
    // 2D / Jagged Arrays:
    // static void main() {
        // For array of same column length
        // int arr [][] = {
        //     {1,2,3},
        //     {10,20,30},
        //     {100,200,300}
        // };

        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {
        //         System.out.print(arr[i][j]+ " ");
        //     }
        //     System.out.println();
        // }

        // For array of different column length
        // int arr2 [][] = {
        //     {1,2,3,4},
        //     {10,20},
        //     {100,200,300,400,500}
        // };

        // for (int i = 0; i < arr2.length; i++) {
        //     for (int j = 0; j < arr2[i].length; j++) {
        //         System.out.print(arr2[i][j]+ " ");
        //     }
        //     System.out.println();
        // }

        // int arr3 [][] = new int[3][];
        // arr3[0] = new int[]{10,20,30,40};
        // arr3[1] = new int[]{11,22};
        // arr3[2] = new int[]{15,30,45,60,75,90};

        // for (int i = 0; i < arr3.length; i++) {
        //     for (int j = 0; j < arr3[i].length; j++) {
        //         System.out.print(arr3[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
    // }

    // static void main () {
        // Input in 2D array:
        // int arr[][] = new int[3][4];

        // Scanner sc = new Scanner(System.in);

        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[i].length; j++) {
        //         System.out.print("Enter value for position ["+i+"]["+j+"]: ");
        //         arr[i][j] = sc.nextInt();
        //     }
        // }

        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[i].length; j++) {
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // Sum of an array
    //     int arr2[][] = {
    //         {1,2,3,4},
    //         {11,12,13,-14},
    //         {21,22,23,24}
    //     };

    //     int sum = 0;
    //     int min = arr2[0][0];
    //     int max = arr2[0][0];
    //     int mult = 1;        

    //     for (int i = 0; i < arr2.length; i++) {
    //         for (int j = 0; j < arr2[i].length; j++) {
    //             sum += arr2[i][j];
                
    //             mult *= arr2[i][j];
                
    //             if (arr2[i][j] > max) {
    //                 max = arr2[i][j];
    //             }

    //             if (arr2[i][j] < min) {
    //                 min = arr2[i][j];
    //             }
    //         }
    //     }
    //     System.out.println("Min: "+min);
    //     System.out.println("Max: "+max);
    //     System.out.println("Sum: "+sum);
    //     System.out.println("Multiplication: "+(mult*(-1)));
    // }

    static int [] reverseArray (int arr []) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    int [] sortArrayOfBinary (int arr[]) {
        int n = arr.length; 
        int i = 0;
        int j = n-1;

        while (i < j) {
            if (arr[i] == 1 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[i] == 0) {
                i++;
            }
            if (arr[j] == 1) {
                j--;
            }
        }
        return arr;
    }

    int missingNumber (int arr[]) {
        int xorSum = 0;
        for (int num: arr) {
            xorSum ^= num;
        }

        for (int i=0; i<arr.length; i++) {
            xorSum ^= i;
        }

        xorSum ^= arr.length;

        return xorSum;
    }

    int missingNumber2 (int arr[]) {
        int sum = 0;
        int arrSum = 0;
        
        for (int i=0; i<arr.length; i++) {
            sum += i+1;
            arrSum += arr[i];
        }

        return sum-arrSum;
    }

    int findUniqueElement (int arr[]) {
        int xorNum = 0;

        for (int i=0; i<=arr.length; i++) {
            xorNum ^= arr[i];
        }

        return xorNum;
    }

    // INDEX MARKING
    List<Integer> missingNum (int arr[]) {
        int n = arr.length;

        for (int index=0; index<n; index++) {
            int value = Math.abs(arr[index]);
            int position = value - 1;
            
            if (arr[position] > 0) {
                arr[position] = -arr[position];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if(arr[i]>0) {
                res.add(i+1);
            }
        }
        return res;
    }

    List<List<Integer>> parisInArray (int arr[]) {
        int n = arr.length;
        List<List<Integer>> pairs = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                pairs.add(Arrays.asList(arr[i],arr[j]));
            }
        }
        return pairs;
    }

    List<List<Integer>> SubArrays (int arr[]) {
        List<List<Integer>> subArr = new ArrayList<>();
        int n = arr.length;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                List<Integer> temp = new ArrayList<>();
                for (int k=i; k<=j; k++) {
                    temp.add(arr[k]);
                }
                subArr.add(temp);
            }
        }

        return subArr;
    }

    List<List<Integer>> SubArraysBetter (int arr[]) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=i; j<n; j++) {
                temp.add(arr[j]);
                res.add(temp);
            }
        }
        return res;
    }

    int maxSubArraySum (int arr[]) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int currSum = 0;
                for (int k=i; k<=j; k++) {
                    currSum += arr[k];
                }
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }

        return maxSum;
    }

    int pivotIndex (int arr[], int target) {
        int n = arr.length;
        int prefixSum[] = new int[n];
        int suffixSum[] = new int[n];

        prefixSum[0] = arr[0];
        for (int i=1; i<n; i++) {
            prefixSum[i] = arr[i] + prefixSum[i-1];
        }

        suffixSum[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--) {
            suffixSum[i] = arr[i] + suffixSum[i+1];
        }

        for (int i=0; i<n; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                return i;
            }
        }

        return -1;
    }

    void main (String [] args) {
        // int arr [] = {5,10,15,20,25,30,35,40,45,50};
        // System.out.println(Arrays.toString(arr));
        // System.out.println("Reversed Array: "+Arrays.toString(reverseArray(arr)));
        
        // int arr[] = {0,1,1,0,1,0,1,0};
        // System.out.println(Arrays.toString(sortArrayOfBinary(arr)));

        // int arr[] = {1,2,3,2,4,5,1,5,3};
        // System.out.println(findUniqueElement(arr));

        int arr [] = {1,-2,3,-1,4,2,-3,5};
        System.out.println(SubArrays(arr));
    }
}