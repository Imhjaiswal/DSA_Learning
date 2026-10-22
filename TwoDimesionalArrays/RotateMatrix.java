package TwoDimesionalArrays;

public class RotateMatrix {
    void rotateBy90Degrees (int mat[][], int N) {
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int row=0; row<N; row++) {
            int startCol = 0;
            int endCol = N-1;

            while (startCol < endCol) {
                int temp = mat[row][startCol];
                mat[row][startCol] = mat[row][endCol];
                mat[row][endCol] = temp;

                startCol++;
                endCol--;
            }
        }
    }
}
