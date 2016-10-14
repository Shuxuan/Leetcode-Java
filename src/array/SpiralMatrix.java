package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuxuannie on 7/17/16.
 */
public class SpiralMatrix {


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return rst;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        while (count * 2 < row && count * 2 < col) {
            for (int i = count; i < col - count; i++) {
                rst.add(matrix[count][i]);
            }

            for (int i = count + 1; i < row - count; i++) {
                rst.add(matrix[i][col-1-count]);
            }

            if ( col - count * 2 == 1 || row - count * 2 == 1)
            // if only one row /col remains
            {
                break;
            }

            for (int i = col - count -2; i >= count; i--) {
                rst.add(matrix[row - count - 1][i]);
            }

            for (int i = row - count - 2; i >= count + 1; i--) {
                rst.add(matrix[i][count]);
            }
            count++;
        }

        return rst;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        SpiralMatrix.spiralOrder(matrix);
    }
}
