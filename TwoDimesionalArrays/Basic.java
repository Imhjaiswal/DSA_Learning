package TwoDimesionalArrays; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic {
    List<Integer> sumOfEachRow(int arr[][]) {
        List<Integer> res = new ArrayList<>();
        int m = arr.length;
        int n = arr[0].length;

        for (int i=0; i<m; i++) {
            int sum = 0;
            for (int j=0; j<n; j++) {
                sum += arr[i][j];
            }
            res.add(sum);
        }
        return res;
    }

    List<Integer> sumOfEachCol (int arr[][]) {
        List<Integer> result = new ArrayList<>();
        int m = arr.length;
        int n = arr[0].length;

        for (int col=0; col<n; col++) {
            int sum = 0;
            for (int row=0; row<m; row++) {
                sum += arr[row][col];
            }
            result.add(sum);
        }
        return result;
    }

    List<Integer> waveMatrix (int nums [][]) {
        int rowLen = nums.length;
        int colLen = nums[0].length;
        List<Integer> res = new ArrayList<>();

        for (int col=0; col<colLen; col++) {
            if ((col % 2) == 1) {
                for (int row=rowLen-1; row>=0; row--) {
                    res.add(nums[row][col]);
                }
            } else if ((col % 2) == 0) {
                for (int row=0; row<rowLen; row++) {
                    res.add(nums[row][col]);
                }
            }
        }
        return res;
    }

    int[][] TransposeMatrix (int nums [][]) {
        if (nums == null || nums.length == 0) return new int[0][0];

        int rowLen = nums.length;
        int colLen = nums[0].length;

        int[][] transpose = new int[colLen][rowLen];

        for (int row=0; row<rowLen; row++) {
            for (int col=0; col<colLen; col++) {
                transpose[col][row] = nums[row][col];
            }
        }
        
        return transpose;
    }

    void rotateBy90Degrees (int nums[][], int N) {
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }

        for (int row=0; row<N; row++) {
            int startCol = 0;
            int endCol = N-1;

            while (startCol <= endCol) {
                int temp = nums[row][startCol];
                nums[row][startCol] = nums[row][endCol];
                nums[row][endCol] = temp;

                startCol++;
                endCol--;
            }
        }
    }

    List<Integer> spiralMatrix (int matrix[][]) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (left<=right && top<=bottom) {
            // LEFT->RIGHT
            for (int i=left; i<=right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            // TOP->BOTTOM
            for (int j=top; j<=bottom; j++) {
                result.add(matrix[j][right]);
            }
            right--;
            // RIGHT->LEFT
            if (top <= bottom) {
                for (int i=right; i>=left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // BOTTOM->TOP
            if (left <= right) {
                for (int j=bottom; j>=top; j--) {
                    result.add(matrix[j][left]);
                }
                left++;
            }
        }
        return result;
    }

    void main () {
        int arr[][] = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        // System.out.println(sumOfEachRow(arr));
        // System.out.println(sumOfEachCol(arr));
        System.out.println((Arrays.deepToString(TransposeMatrix(arr))));
    }
}