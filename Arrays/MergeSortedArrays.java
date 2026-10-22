package Arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    // BRUTEFORCE
    //  T.C. - O(2 * (N1 + N2))
    //  S.C. - O(N)
    void bruteforce (int n1[], int n2[]) {
        int a = n1.length;
        int b = n2.length;
        int i = 0;
        int j = 0;
        int nums[] = new int [a+b];
        int index = 0;

        while (i < a && j < b) {
            if (n1[i] <= n2[j]) {
                nums[index++] = n1[i++];
            } else {
                nums[index++] = n2[j++];
            }
        }

        while (i < a) {
            nums[index++] = n1[i++];
        }

        while (j < b) {
            nums[index++] = n2[j++];
        }

        for (int k=0; k<a+b; k++) {
            if (k < a) {
                n1[k] = nums[k];
            }
            else {
                n2[k-a] = nums[k];
            }
        }
    }

    // OPTIMAL 1
    // T.C. - O(nlogn + mlogm + min(n,m))
    // S.C. - O(1)
    void optimal1 (int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int i = n-1;
        int j = 0;

        while (i >= 0 && j < m && arr1[i] > arr2[j]) {
            swap (arr1, arr2, i, j);
            i--;
            j++;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    void swap (int n1[], int n2[], int one, int two) {
        int temp = n1[one];
        n1[one] = n2[two];
        n2[two] = temp;
    }
}
