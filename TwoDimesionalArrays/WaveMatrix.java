package TwoDimesionalArrays;

import java.util.ArrayList;
import java.util.List;

public class WaveMatrix {
    List<Integer> waveMat (int mat[][]) {
        List<Integer> wave = new ArrayList<>();

        for (int col=0; col<mat[0].length; col++) {
            if (col % 2 == 0) {
                for (int row=0; row<mat.length; row++) {
                    wave.add(mat[row][col]);
                }
            } 
            else {
                for (int row=mat.length-1; row>=0; row--) {
                    wave.add(mat[row][col]);
                }
            }
        }

        return wave;
    }
}
