package dynamicprogramming;

/**
 * Created by shuxuannie on 7/25/16.
 *
 * https://leetcode.com/problems/bomb-enemy/
 *
 * 361. Bomb Enemy  QuestionEditorial Solution  My Submissions
 Total Accepted: 1713
 Total Submissions: 4995
 Difficulty: Medium
 Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 Note that you can only put the bomb at an empty cell.

 Example:
 For the given grid

 0 E 0 0
 E 0 W E
 0 E 0 0

 return 3. (Placing a bomb at (1,1) kills 3 enemies)
 Credits:
 Special thanks to @memoryless for adding this problem and creating all test cases.

 Hide Company Tags Google
 Hide Tags Dynamic Programming


 */
public class BombEnemy {

    //brute force
    public static int maxKilledEnemies(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;


        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (grid[i][j] == 'O') {
                    //计算这个节点能杀死的enemy个数
                    //count on row i

                    for (int k = j-1; k >= 0; k--) {
                        if (grid[i][k] == 'W') {
                            break;
                        }
                        count += grid[i][k] == 'E' ? 1 : 0;
                    }

                    for(int k = j+1; k < n; k++) {
                        if (grid[i][k] == 'W') {
                            break;
                        }
                        count += grid[i][k] == 'E' ? 1 : 0;
                    }
                    //count on collumn j

                    for (int k = i-1; k>= 0; k--) {
                        if (grid[k][j] == 'W') {
                            break;
                        }
                        count += grid[k][j] == 'E' ? 1 : 0;
                    }

                    for (int k = i+1; k < m; k++) {
                        if (grid[k][j] == 'W') {
                            break;
                        }
                        count += grid[k][j] == 'E' ? 1 : 0;
                    }
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] grid = {{'O', 'E', 'O', 'O'},{'E', 'O', 'W', 'E'},{'O', 'E', 'O', 'O'}};
        System.out.println(BombEnemy.maxKilledEnemies(grid));
    }
}
