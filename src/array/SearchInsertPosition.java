package array;

/**
 * Created by shuxuannie on 7/17/16.
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] >= target) {
            return start;
        }

        if (nums[end] >= target) {
            return end;
        }

        return end + 1;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;

        System.out.println(SearchInsertPosition.searchInsert(nums, target));
    }
}
