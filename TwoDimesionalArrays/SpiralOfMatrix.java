package TwoDimesionalArrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOfMatrix {
    List<Integer> spiral (int mat[][]) {
        List<Integer> result = new ArrayList<>();

        if (mat == null || mat.length == 0|| mat[0].length == 0) return result;

        int left = 0;
        int right = mat[0].length-1;
        int top = 0;
        int bottom = mat.length-1;

        while (left <= right && top <= bottom) {
            // LEFT -> RIGHT
            for (int i=left; i<=right; i++) {
                result.add(mat[top][i]);
            }
            top++;
            // TOP -> BOTTOM
            for (int i=top; i<=bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;
            // RIGHT -> LEFT
            if (left <= right) {
                for (int i=right; i>=left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--;
            }
            // BOTTOM -> TOP
            if (top <= bottom) {
                for (int i=bottom; i>=top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
