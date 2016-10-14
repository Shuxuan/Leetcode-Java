package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuxuannie on 8/5/16.
 *
 *
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * 329. Longest Increasing Path in a Matrix  QuestionEditorial Solution  My Submissions
 Total Accepted: 18124
 Total Submissions: 54530
 Difficulty: Hard
 Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 Credits:
 Special thanks to @dietpepsi for adding this problem and creating all test cases.

 Hide Company Tags Google
 Hide Tags Depth-first Search Topological Sort Memoization


 */
public class LongestIncreasingPathInaMatrix {

    int max = 1;
    int[][] visited;
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(matrix, i, j, visited, new ArrayList<Integer>());
            }
        }

        return max;
    }

    public void helper(int[][] matrix, int row, int col, int[][] visited, List<Integer> path) {
        visited[row][col] = 1;
        path.add(matrix[row][col]);
        max = Math.max(max, path.size());
        for (int i = 0; i < 4; i++ ) {
            int x = row + dx[i];
            int y = col + dy[i];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && visited[x][y] == 0 && matrix[row][col] < matrix[x][y]) {
                helper(matrix, x, y, visited, path);
            }
        }

        visited[row][col] = 0;
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,2,1}};
        LongestIncreasingPathInaMatrix obj = new LongestIncreasingPathInaMatrix();
        System.out.println(obj.longestIncreasingPath(matrix));
    }
}
