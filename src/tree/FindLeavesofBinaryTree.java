package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuxuannie on 7/25/16.
 *
 *
 * 366. Find Leaves of Binary Tree  QuestionEditorial Solution  My Submissions
 Total Accepted: 2421
 Total Submissions: 4582
 Difficulty: Medium
 Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:
 Given binary tree
 1
 / \
 2   3
 / \
 4   5
 Returns [4, 5, 3], [2], [1].

 Explanation:
 1. Removing the leaves [4, 5, 3] would result in this tree:

 1
 /
 2
 2. Now removing the leaf [2] would result in this tree:

 1
 3. Now removing the leaf [1] would result in the empty tree:

 []
 Returns [4, 5, 3], [2], [1].

 Credits:
 Special thanks to @elmirap for adding this problem and creating all test cases.

 Hide Company Tags LinkedIn
 Hide Tags Tree Depth-first Search



 */
public class FindLeavesofBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();

        if (root == null) {
            return rst;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        depth(root, map);

        for (int i : map.keySet()) {
            rst.add(map.get(i));
        }

        return rst;
    }

    public int depth(TreeNode root, HashMap<Integer, List<Integer>> map) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left, map);
        int right = depth(root.right, map);
        int root_depth = 1 + Math.max(left, right);

        if (!map.containsKey(root_depth)) {
            map.put(root_depth, new ArrayList<>());
        }
        map.get(root_depth).add(root.val);

        return root_depth;
    }

}
