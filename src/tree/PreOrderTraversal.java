package tree;

import java.util.List;
import java.util.Stack;

/**
 * Created by shuxuannie on 7/6/16.
 */
public class PreorderTraversal {

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

        PreorderTraversal.preorderRec(r1);
        PreorderTraversal.preorder(r1);

    }

    public static void preorderRec(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preorderRec(root.left);
        preorderRec(root.right);
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);


        while ( !stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);


            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
}
