package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuxuannie on 7/6/16.
 */
public class GetTreeDepth {

    public static void main(String[] args) {
    /*
                 1
                / \
               2   3
              / \   \
             4  5   6
     */

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;

        System.out.println(GetTreeDepth.getDepth(r1));
        System.out.println(GetTreeDepth.getDepthRec(r1));

    }

    public static int getDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return depth;
    }
}
