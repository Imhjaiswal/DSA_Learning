package TwoDimesionalArrays;

public class BinarySearch2D {
    boolean binarySearch (int matrix[][], int target) {
        if (matrix == null || matrix.length == 0) return false;

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int n = rowLen * colLen;
        int start = 0;
        int end = n-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            
            int rowIndex = mid / colLen;
            int colIndex = mid % colLen;

            if (matrix[rowIndex][colIndex] == target) {
                return true;
            }
            else if (matrix[rowIndex][colIndex] > target) {
                end = mid - 1;
            }   
            else {
                start = mid + 1;
            }
        }
        return false;
    }

    boolean searchInA2dMatrix2 (int nums[][], int target) {
        int totalRow = nums.length;
        int totalCol = nums[0].length;

        int row = 0;
        int col = totalCol - 1;

        while (row < totalRow && col >= 0) {
            if (nums[row][col] == target) {
                return true;
            }
            else if (nums[row][col] > target) {
                col--;
            }
            else {
                // nums[row][col] < target
                row++;
            }
        }
        return false;
    } 
}