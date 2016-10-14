package array;

/**
 * Created by shuxuannie on 7/22/16.
 */
public class WiggleSubSequence {
    public static int wiggleMaxLength(int[] nums) {

        //two pointers begin, end --> maintain wiggle window ,
        //count 纪录当前找到的wiggle个数（以i为起点的），end.val 纪录每一次尝试遍历的window end的值
        //每找到一个wiggle，更新max

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 1;
        for (int i = 0; i < nums.length -1; i++) {
            int count = 1;
            int j = i+1;
            int end = i;
            while ( j < nums.length) {
                if (count % 2 != 0) {
                    // search possile j that nums[j] > nums[end]
                    while ( j< nums.length && nums[j] <= nums[end]) {
                        j++;
                    }
                    if (j < nums.length) {
                        count++;
                        max = Math.max(count, max);
                        end = j;
                    }
                } else {
                    while ( j < nums.length && nums[j] >= nums[end]) {
                        j++;
                    }
                    if (j < nums.length) {
                        count++;
                        max = Math.max(count, max);
                        end = j;
                    }
                }

                j++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15};
        WiggleSubSequence.wiggleMaxLength(nums);


    }
}
