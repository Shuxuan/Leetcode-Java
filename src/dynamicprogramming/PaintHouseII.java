package dynamicprogramming;

import java.util.PriorityQueue;

/**
 * Created by shuxuannie on 7/26/16.
 *
 * 265. Paint House II  QuestionEditorial Solution  My Submissions
 Total Accepted: 9124
 Total Submissions: 25313
 Difficulty: Hard
 There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 Follow up:
 Could you solve it in O(nk) runtime?

 Hide Company Tags Facebook
 Hide Tags Dynamic Programming
 Hide Similar Problems (M) Product of Array Except Self (H) Sliding Window Maximum (M) Paint House (E) Paint Fence



 */
public class PaintHouseII {

    //dp[i][j] 刷到第i个房子用jcolor的最小花费
    //dp[i][j] = costs[i-1][j] + min(dp[i-1][!=j])
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n+1][k];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < k; i++) {
            dp[1][i] = costs[0][i];
            queue.offer(costs[0][i]);
        }

        for (int i = 2; i <= n; i++) {

            PriorityQueue<Integer> new_queue = new PriorityQueue<Integer>();
            for (int j = 0; j < k; j++) {
                int min = queue.peek();
                if(dp[i-1][j] == min) {
                    queue.poll();
                }
                dp[i][j] = costs[i-1][j] + queue.peek();
                new_queue.offer(dp[i][j]);
                if(dp[i-1][j] == min) {
                    queue.offer(min);
                }
            }
            queue = new_queue;
        }

        return queue.peek();
    }
}
