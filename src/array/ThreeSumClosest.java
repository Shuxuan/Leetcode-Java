package array;

import java.util.Arrays;

/**
 * Created by shuxuannie on 7/11/16.
 *
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

 For example, given nums = [-2, 0, 1, 3], and target = 2.

 Return 2. Because there are two triplets which sums are less than 2:

 [-2, 0, 1]
 [-2, 0, 3]
 Follow up:
 Could you solve it in O(n2) runtime?

 */
public class ThreeSumClosest {

    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    //left --> right 的任意组合都是answer
                    ans += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }
}
