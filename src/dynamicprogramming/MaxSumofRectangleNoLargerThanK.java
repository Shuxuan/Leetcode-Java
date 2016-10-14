package dynamicprogramming;

/**
 * Created by shuxuannie on 8/3/16.
 *
 * https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
 *
 * 363. Max Sum of Rectangle No Larger Than K  QuestionEditorial Solution  My Submissions
 Total Accepted: 3015
 Total Submissions: 10192
 Difficulty: Hard
 Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

 Example:
 Given matrix = [
 [1,  0, 1],
 [0, -2, 3]
 ]
 k = 2
 The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

 Note:
 The rectangle inside the matrix must have an area > 0.
 What if the number of rows is much larger than the number of columns?
 Credits:
 Special thanks to @fujiaozhu for adding this problem and creating all test cases.

 Hide Company Tags Google
 Hide Tags Binary Search Dynamic Programming Queue
 Have you met this question in a real interview? Yes


 */
public class MaxSumofRectangleNoLargerThanK {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] sum = new int[m][n];
        //sum[i][j]是以[0，0]为起点，[i，j]为终点的矩形的sum
        int max_area = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = matrix[i][j];
                if (i > 0) {
                    sum[i][j] += sum[i-1][j];
                }
                if (j > 0) {
                    sum[i][j] += sum[i][j-1];
                }
                if (i > 0 && j > 0) {
                    sum[i][j] -= sum[i-1][j-1];
                }

                for (int r = 0; r < i; r++) {
                    for (int c = 0; c < j; c++) {
                        int area = sum[i][j] - sum[r][j] - sum[i][c] + sum[r][c];
                        if (area == k) {
                            return area;
                        }
                        if (area < k) {
                            max_area = Math.max(max_area, area);
                        }
                    }
                }
            }
        }

        return max_area;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,1},{0,-2,3}};
        int k = 2;
        MaxSumofRectangleNoLargerThanK.maxSumSubmatrix(matrix, k);
    }
}
