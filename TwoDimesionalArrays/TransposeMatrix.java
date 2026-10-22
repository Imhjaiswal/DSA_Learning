package TwoDimesionalArrays;

public class TransposeMatrix {
    int [][] transpose (int nums[][]) {
        if (nums == null || nums.length == 0) return new int[0][0];

        int row = nums.length;
        int col = nums[0].length;

        int result[][] = new int [col][row];

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                result[j][i] = nums[i][j];
            }
        }
        return result;    
    }
}
