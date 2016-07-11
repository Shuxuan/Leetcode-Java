package string;

import java.util.HashMap;

/**
 * Created by shuxuannie on 7/8/16.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.



 一个数字旋转180度和原来一样，也就是倒过来看一样，比如609，倒过来还是609等等，满足这种条件的数字其实没有几个，只有0,1,8,6,9。
 这道题其实可以看做求回文数的一种特殊情况，我们还是用双指针来检测，那么首尾两个数字如果相等的话，那么只有它们是0,1,8中间的一个才行，
 如果它们不相等的话，必须一个是6一个是9，或者一个是9一个是6，其他所有情况均返回false

 */
public class StrobogrammaticNumber {

    public static void main(String[] args) {

        String num = "6129";
        System.out.println(StrobogrammaticNumber.isStrobogrammatic(num));
    }

    public static boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');

        int left = 0, right = num.length() - 1;

        while (left <= right) {
            if (!map.containsKey(num.charAt(left)) || !map.containsKey(num.charAt(right))) {
                return false;
            }
            if (map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
