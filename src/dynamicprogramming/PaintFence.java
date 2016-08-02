package dynamicprogramming;

/**
 * Created by shuxuannie on 7/26/16.
 *
 *
 * 276. Paint Fence  QuestionEditorial Solution  My Submissions
 Total Accepted: 10851
 Total Submissions: 33858
 Difficulty: Easy
 There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color.

 Return the total number of ways you can paint the fence.

 Note:
 n and k are non-negative integers.

 Hide Company Tags Google
 Hide Tags Dynamic Programming
 Hide Similar Problems (E) House Robber (M) House Robber II (M) Paint House (H) Paint House II



 */
public class PaintFence {

    /*
    n == 0, 房子为0个，刷法是0
    n == 1, 有多少种颜色，就多少种刷法， return k
    n == 2, 第一种情况，颜色和前一块不相同 diffColor = k * (k-1)
            第二种情况，颜色和前一块相同： sameColor = k
            f[2] = diffColor + sameColor
    n >= 3: 颜色和前一块相同，就是上一次的不同颜色的种类,只有不同颜色的,才能选相同颜色的
            颜色和前一块不相同,上一次所有可能性 * (k - 1)


    那么我们首先来分析一下，如果n=0的话，说明没有需要刷的部分，直接返回0即可，如果n为1的话，那么有几种颜色，就有几种刷法，所以应该返回k，当n=2时，k=2时，我们可以分两种情况来统计，一种是相邻部分没有相同的，一种相同部分有相同的颜色，那么对于没有相同的，对于第一个格子，我们有k种填法，对于下一个相邻的格子，由于不能相同，所以我们只有k-1种填法。而有相同部分颜色的刷法和上一个格子的不同颜色刷法相同，因为我们下一格的颜色和之前那个格子颜色刷成一样的即可，最后总共的刷法就是把不同和相同两个刷法加起来

    */

    public int numWays(int n, int k) {
        if (n == 0 || k == 1 && n >= 3) {
            return 0;
        }

        int diffColor = k;
        int sameColor = 0;
        int res = diffColor + sameColor;

        for (int i = 2; i <= n; i++) {
            sameColor = diffColor;
            diffColor = res * (k-1);
            res = sameColor + diffColor;
        }

        return res;
    }
}
