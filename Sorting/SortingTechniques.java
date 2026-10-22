package Sorting;

public class SortingTechniques {
    void BubbleSort (int arr[]) { // T.C. - O(N**2)
        int n = arr.length;
        for (int i=0; i<n-1; i++) { // Rounds
            for (int j=0; j<n-i-1; j++) { // Comparison of Adjacent Elements 
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    void SelectionSort (int arr[]) {
        int n = arr.length;

        for (int i=0; i<n-1; i++) {
            int minIndex = i;
            // FIND MINIMUM NUMBER
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // SWAP AFTER FINDING MINIMUM NUMBER
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    void InsertionSort (int arr[]) {
        int n = arr.length;

        for (int i=1; i<n; i++) {
            int currPos = i;
            int prevPos = i-1;
            int currVal = arr[currPos];

            while (prevPos >= 0 && currVal < arr[prevPos]) {
                arr[prevPos+1] = arr[prevPos];
                prevPos--;
            }
            arr[prevPos+1] = currVal;
        }
    }
}
