package dynamicprogramming;

/**
 * Created by shuxuannie on 8/2/16.
 */
public class CombinationSumIV {

    /*

    我们需要一个一维数组dp，其中dp[i]表示目标数为i的解的个数，然后我们从1遍历到target，对于每一个数i，遍历nums数组，如果i>=x, dp[i] += dp[i - x]。这个也很好理解，比如说对于[1,2,3] 4，这个例子，当我们在计算dp[3]的时候，3可以拆分为1+x，而x即为dp[2]，3也可以拆分为2+x，此时x为dp[1]，3同样可以拆为3+x，此时x为dp[0]，我们把所有的情况加起来就是组成3的所有情况了

    */
    public int combinationSum4(int[] nums, int target) {
        int[] dp= new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target;i++){
            for(int num:nums){
                if(i >= num) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

}
