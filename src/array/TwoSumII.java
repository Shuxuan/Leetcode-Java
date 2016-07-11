package array;

/**
 * Created by shuxuannie on 7/11/16.
 *
 * Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.


 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2


 */
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return null;
        }

        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left+1;
                result[1] = right+1;
                return result;
            } else if ( sum > target) {

                right--;


            } else {
                left++;

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {0,0,3,4};
        int target = 0;
        TwoSumII.twoSum(numbers, target);
    }

}
