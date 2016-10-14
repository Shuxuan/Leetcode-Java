package array;

import java.util.Arrays;

/**
 * Created by shuxuannie on 7/18/16.
 */
public class WiggleSortII {

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int s = (nums.length + 1) >> 1, t = nums.length;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = (i & 1) == 0 ?  nums[--s] : nums[--t] ;
        }

        for (int i = 0; i < nums.length; i++)
            nums[i] = temp[i];

    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        WiggleSortII.wiggleSort(nums);
    }
}
