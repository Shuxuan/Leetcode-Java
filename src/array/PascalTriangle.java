package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuxuannie on 7/16/16.
 *
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();
        if (numRows == 0) {
            return rst;
        }

        List<Integer> first = new ArrayList<>();
        first.add(1);
        rst.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                ans.add(-1);
            }

            List<Integer> prev = rst.get(i-1);
            ans.set(0, 1);
            ans.set(i, 1);
            for (int j = 1; j < i; j++) {
                ans.set(j, prev.get(j-1) + prev.get(j));
            }
            rst.add(ans);
        }
        return rst;
    }
}
