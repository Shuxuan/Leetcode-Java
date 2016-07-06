package tree;
import java.util.ArrayList;

/**
 * Created by shuxuannie on 7/5/16.
 */
public class TreeNode {
    int val;
    ArrayList<TreeNode> subNodes;
    public TreeNode(int val, ArrayList<TreeNode> subNodes) {
        this.val = val;
        this.subNodes = subNodes;
    }
}
