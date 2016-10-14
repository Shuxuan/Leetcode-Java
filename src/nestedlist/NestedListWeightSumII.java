package nestedlist;

import java.util.List;

/**
 * Created by shuxuannie on 7/25/16.
 *
 *
 * 364. Nested List Weight Sum II  QuestionEditorial Solution  My Submissions
 Total Accepted: 1798
 Total Submissions: 3828
 Difficulty: Medium
 Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

 Example 1:
 Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

 Example 2:
 Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)

 Hide Company Tags LinkedIn
 Hide Tags Depth-first Search
 Hide Similar Problems (E) Nested List Weight Sum



 */
public class NestedListWeightSumII {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = depth(nestedList, 1);
        return sum(nestedList, depth);
    }

    public int sum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger ni = nestedList.get(i);
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += sum(ni.getList(), depth - 1);
            }
        }

        return sum;
    }

    public int depth(List<NestedInteger> nestedList, int depth) {
        int max = depth;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger ni = nestedList.get(i);
            if (!ni.isInteger()) {
                int cur = depth(ni.getList(), depth + 1);
                max = Math.max(max, cur);
            }
        }
        return max;
    }

}
