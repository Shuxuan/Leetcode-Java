package dynamicprogramming;

/**
 * Created by shuxuannie on 7/26/16.
 *
 * 256. Paint House  QuestionEditorial Solution  My Submissions
 Total Accepted: 9724
 Total Submissions: 22311
 Difficulty: Medium
 There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 Hide Company Tags LinkedIn
 Hide Tags Dynamic Programming
 Hide Similar Problems (E) House Robber (M) House Robber II (H) Paint House II (E) Paint Fence


 */
public class PaintHouse {

    /*
    dp[i][j]表示刷到第i+1房子用颜色j的最小花费
    dp[1][0] = costs[0][0];
    dp[1][1] = costs[0][1];
    dp[1][2] = costs[0][2];

    dp[i][j]: cost[i-1][j] + min(dp[i-1][!=j], dp[i-1][!=j])
    */
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n+1][3];

        for (int i = 0; i < 3; i++) {
            dp[1][i] = costs[0][i];
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = costs[i-1][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i-1][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i-1][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        return Math.min(dp[n][0], Math.min(dp[n][1],dp[n][2]));

    }
}
