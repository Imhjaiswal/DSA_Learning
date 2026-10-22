package Arrays;
import java.util.Arrays;

public class ArraysQuestions3 {
    static int[] sortArr (int arr[]) {
        int n = arr.length;
        int i = 0;
        int j = n-1;

        while (i < j) {
            if (arr[i] == 1 && arr[j] == 0) {
                arr[i] = 0;
                arr[j] = 1;
            } 
            else if (arr[i] == 0) {
                i++;
            } 
            else if (arr[j] == 1) {
                j--;
            }
        }
        return arr;
    }

    void main () {
        int arr1[] = {1,0,0,1,0,1,1};
        System.out.println(Arrays.toString(sortArr(arr1)));
    }
}
