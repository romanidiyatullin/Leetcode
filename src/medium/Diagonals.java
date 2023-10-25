package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Diagonals {
    public static int[] findDiagonalOrder(int[][] mat) {

        if (mat == null || mat.length == 0)
            return new int[0];

        int height = mat.length;
        int width = mat[0].length;

        int[] solution = new int[height*width];

        List<Integer> diagList = new ArrayList<>();

        int solIndex = 0;

        for (int count = 0; count < height + width - 1; count++) {

            diagList.clear();

            int i = count < width ? 0 : count - width + 1;
            int j = count < width ? count : width - 1;

            while (i < height && j > -1) {

                diagList.add(mat[i][j]);
                ++i;
                --j;
            }

            if (count % 2 == 0)
                Collections.reverse(diagList);


            for (int element: diagList)
                solution[solIndex++] = element;
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
    }
}
