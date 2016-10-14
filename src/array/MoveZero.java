package array;

/**
 * Created by shuxuannie on 7/19/16.
 */
public class MoveZero {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int j = i+1;
            while(j < n && nums[j] == 0) {
                j++;
            }

            if (j < n) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZero obj = new MoveZero();
        obj.moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
