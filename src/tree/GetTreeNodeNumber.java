package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by shuxuannie on 7/6/16.
 */
public class GetTreeNodeNumber {

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

        System.out.println(GetTreeNodeNumber.getNodeNumRec(r1));
        System.out.println(GetTreeNodeNumber.getNodeNum(r1));
    }

    public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getNodeNumRec(root.left);
        int right = getNodeNumRec(root.right);

        return left + right + 1;
    }

    public static int getNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int num = 0;

        while ( !queue.isEmpty() ) {
            TreeNode cur = queue.poll();
            num++;
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return num;
    }
}
