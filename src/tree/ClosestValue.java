package tree;

/**
 * Created by shuxuannie on 7/20/16.
 */
public class ClosestValue {

    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while(root != null){
            System.out.println(Math.abs(target - root.val));
            System.out.println(Math.abs(target - ret));
            if(Math.abs(target - root.val) < Math.abs(target - ret)){
                ret = root.val;
            }
            root = root.val > target? root.left: root.right;
        }
        return ret;
    }

    public static void main(String[] args) {
        double target = 3.4;
        ClosestValue obj = new ClosestValue();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        obj.closestValue(root, target);
    }
}
