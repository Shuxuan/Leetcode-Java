package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuxuannie on 7/16/16.
 *
 *
 *
 * 163. Missing Ranges  QuestionEditorial Solution  My Submissions
 Total Accepted: 12889
 Total Submissions: 43033
 Difficulty: Medium
 Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].



 */
public class MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> ranges = new ArrayList<>();
        int prev = lower - 1; //first element my be missing
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i == nums.length) ? upper + 1 : nums[i];
            if (curr - prev >= 2) {
                ranges.add(getRanges(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return ranges;
    }

    public static String getRanges(int from, int to) {
        return (from == to) ? Integer.toString(from) : from + "->" + to;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        System.out.println(MissingRanges.findMissingRanges(nums, lower, upper));
    }

}
