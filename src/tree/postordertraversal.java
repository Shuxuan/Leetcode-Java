package tree;

import java.util.Stack;

/**
 * Created by shuxuannie on 7/6/16.
 */
public class Postordertraversal {

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

        Postordertraversal.postorderRec(r1);
        Postordertraversal.postorder(r1);



    }

    public static void postorderRec(TreeNode root) {
        if (root == null) {
            return;
        }

        postorderRec(root.left);
        postorderRec(root.right);
        System.out.println(root.val);
    }

    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        TreeNode pre = null;

        while (!stack.isEmpty()) {


            cur = stack.peek();

            //结合pre,判断是否需要往左走,往右走还是访问当前节点


            if (pre == null || pre.left == cur || pre.right == cur) {
                //pre 在cur的上面,downhill
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else if (pre == cur.left) {
                //访问完左节点,该往右走
                if (cur.right != null) {
                    stack.push(cur.right);
                }

            } else {
                //访问当前节点
                System.out.println(cur.val);
                stack.pop();
            }

            pre = cur;

        }
    }
}
