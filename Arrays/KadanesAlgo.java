package Arrays;

import java.util.Currency;

// Maximum Sub-Array Question
public class KadanesAlgo {
    int bruteForce (int arr[]) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int currSum = 0;
                for (int k=i; k<=j; k++) {
                    currSum += arr[k];
                }
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        return maxSum;
    }

    int betterApproach (int arr[]) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            int currSum = 0;
            for (int j=i; j<n; j++) {
                currSum += arr[j];
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        return maxSum;
    }

    int bestApproach (int arr[]) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        
        int prefixSum[] = new int [n];
        prefixSum[0] = arr[0];

        for (int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for (int i=0; i<n; i++) {
            int start = i;
            int currSum = 0;
            for (int j=i; j<n; j++) {
                int end = j;
                currSum = start == 0 ? prefixSum[end] :prefixSum[end] - prefixSum[start-1];

                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        return maxSum;
    }

    int kadanes (int arr[]) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i=0; i<n; i++) {
            currSum += arr[i];
            if (currSum < 0) {
                currSum = 0;
            } else {
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }

    int KadanesEdgeCases (int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i=1; i<n; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);

            if (currSum < 0) currSum = 0;
        }

        return maxSum;
    }

    void main () {
        int arr [] = {1,-2,3,-1,4,2,-3,5};
        int arr2 [] = {-2,-3,4,-1,-2,1,5,-3};

        System.out.println(bruteForce(arr));
        System.out.println(betterApproach(arr));
        System.out.println(kadanes(arr));

        System.out.println(bruteForce(arr2));
        System.out.println(betterApproach(arr2));
        System.out.println(kadanes(arr2));
    }
}