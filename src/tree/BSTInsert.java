package tree;

/**
 * Created by shuxuannie on 7/11/16.
 */
public class BSTInsert {

    public TreeNode insert(TreeNode root, TreeNode node ) {
        if (root == null) {
            root = node;
            return root;
        }

        TreeNode tmp = root;
        TreeNode last = null;

        while (tmp != null) {
            last = tmp;
            if (tmp.val > node.val) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }

        if (last != null) {
            if (last.val > node.val) {
                last.left = node;
            } else {
                last.right = node;
            }
        }

        return root;
    }
}
