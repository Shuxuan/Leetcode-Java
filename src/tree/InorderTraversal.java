package tree;

import java.util.Stack;

/**
 * Created by shuxuannie on 7/6/16.
 */
public class InorderTraversal {

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

        InorderTraversal.inorderRec(r1);
        InorderTraversal.inorder(r1);

    }

    public static void inorderRec(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderRec(root.left);
        System.out.println(root.val);
        inorderRec(root.right);
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }
}
