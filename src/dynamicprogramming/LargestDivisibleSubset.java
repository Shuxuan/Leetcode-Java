package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuxuannie on 8/3/16.
 *
 *
 * 368. Largest Divisible Subset  QuestionEditorial Solution  My Submissions
 Total Accepted: 6104
 Total Submissions: 19998
 Difficulty: Medium
 Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 nums: [1,2,3]

 Result: [1,2] (of course, [1,3] will also be ok)
 Example 2:

 nums: [1,2,4,8]

 Result: [1,2,4,8]
 Credits:
 Special thanks to @Stomach_ache for adding this problem and creating all test cases.

 Hide Company Tags Google
 Hide Tags Dynamic Programming Math
 Have you met this question in a real interview? Yes


 */
public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] index = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(index, -1);

        dp[0] = 1;
        index[0] = 0;
        int max_dp = 1, max_index = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    index[i] = j;

                    if (max_dp < dp[i]) {
                        max_dp = dp[i];
                        max_index = i;
                    }
                }

            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = max_index; i >= 0; i = index[i]) {
            ans.add(nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,8};
        System.out.println(LargestDivisibleSubset.largestDivisibleSubset(nums));
    }
}
