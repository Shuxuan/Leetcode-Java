package tree;
import java.util.ArrayList;

/**
 * Created by shuxuannie on 7/5/16.
 */
public class TreeNodeMultiChildren {
    int val;
    ArrayList<TreeNodeMultiChildren> subNodes;
    public TreeNodeMultiChildren(int val, ArrayList<TreeNodeMultiChildren> subNodes) {
        this.val = val;
        this.subNodes = subNodes;
    }
}
