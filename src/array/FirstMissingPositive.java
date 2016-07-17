package array;

/**
 * Created by shuxuannie on 7/15/16.
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] -1]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(FirstMissingPositive.firstMissingPositive(nums));
    }
}
