package tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shuxuannie on 7/5/16.
 */
public class LargestCommonSubtrees {

    /*
     * Function: Find all the common subtrees root that have most number
     */

    public static void main(String[] args) {
        /*
         *             1
         *
         *         /  \    \
         *        2    3    4
         *       / \       / \
         *      5   6     8   9
         *           \         \
         *            7         10
         * */
        TreeNodeMultiChildren r1 = new TreeNodeMultiChildren(1, new ArrayList<TreeNodeMultiChildren>());
        TreeNodeMultiChildren r2 = new TreeNodeMultiChildren(2, new ArrayList<TreeNodeMultiChildren>());
        TreeNodeMultiChildren r3 = new TreeNodeMultiChildren(3, new ArrayList<TreeNodeMultiChildren>());
        TreeNodeMultiChildren r4 = new TreeNodeMultiChildren(4, new ArrayList<TreeNodeMultiChildren>());
        TreeNodeMultiChildren r5 = new TreeNodeMultiChildren(5, new ArrayList<TreeNodeMultiChildren>());
        TreeNodeMultiChildren r6 = new TreeNodeMultiChildren(6, new ArrayList<TreeNodeMultiChildren>());
        TreeNodeMultiChildren r7 = new TreeNodeMultiChildren(7, new ArrayList<TreeNodeMultiChildren>());
        TreeNodeMultiChildren r8 = new TreeNodeMultiChildren(8, new ArrayList<TreeNodeMultiChildren>());
        TreeNodeMultiChildren r9 = new TreeNodeMultiChildren(9, new ArrayList<TreeNodeMultiChildren>());
        TreeNodeMultiChildren r10 = new TreeNodeMultiChildren(10, new ArrayList<TreeNodeMultiChildren>());
/*
        r1.subNodes.add(r2);
        r1.subNodes.add(r3);
        r1.subNodes.add(r4);

        r2.subNodes.add(r5);
        r2.subNodes.add(r6);

        r6.subNodes.add(r7);

        r4.subNodes.add(r8);
        r4.subNodes.add(r9);

        r9.subNodes.add(r10);
*/
        r1.subNodes.add(r2);
        r1.subNodes.add(r3);
        r1.subNodes.add(r4);

        r2.subNodes.add(r5);
        r2.subNodes.add(r6);

        r3.subNodes.add(r7);
        r3.subNodes.add(r8);

        r4.subNodes.add(r9);
        r4.subNodes.add(r10);

        ArrayList<ArrayList<TreeNodeMultiChildren>> ret = largestCommonSubtrees(r1);
        for (ArrayList<TreeNodeMultiChildren> arrayl: ret) {
            for (TreeNodeMultiChildren t: arrayl) {
                System.out.println(t.val);
            }
        }

    }

    public static ArrayList<ArrayList<TreeNodeMultiChildren>> largestCommonSubtrees(TreeNodeMultiChildren root) {
        if (root == null) {
            return null;
        }

        // store all the tree nodes to a arrayList.
        ArrayList<TreeNodeMultiChildren> nodes = new ArrayList<TreeNodeMultiChildren>();
        traversalTree(root, nodes);

        int maxNum = 0;

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        TreeNodeMultiChildren r1 = null;
        TreeNodeMultiChildren r2 = null;


        // compare all the nodes.
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {

                int num = compareTree(nodes.get(i), nodes.get(j), hash);
                if (num > maxNum) {
                    maxNum = num;
                    r1 = nodes.get(i);
                    r2 = nodes.get(j);
                }
            }
        }

        ArrayList<ArrayList<TreeNodeMultiChildren>> retNew = new ArrayList<ArrayList<TreeNodeMultiChildren>>();
        retNew.add(new ArrayList<TreeNodeMultiChildren>());
        retNew.get(0).add(r1);
        retNew.get(0).add(r2);
        return retNew;
    }


    // compare two tree, if same, return the number of leafs. if no, return -1;
    public static int compareTree(TreeNodeMultiChildren r1, TreeNodeMultiChildren r2, HashMap<Integer, Integer> hash) {
        if (r1 == null && r2 == null) {
            return 0;
        }

        if (r1 == null || r2 == null) {
            return -1;
        }

        // the number of subtrees should be same.
        if (r1.subNodes.size() != r2.subNodes.size()) {
            return -1;
        }

        int num = 1; // the root itself.

        for (int i = 0; i < r1.subNodes.size(); i++) {
            // get the subNode of r1.
            TreeNodeMultiChildren subNode1 = r1.subNodes.get(i);
            TreeNodeMultiChildren subNode2 = r2.subNodes.get(i);

            int HashCode = hashCode(subNode1, subNode2);

            Integer numNode = hash.get(HashCode);
            if (numNode == null) {
                numNode = compareTree(subNode1, subNode2, hash);
                hash.put(HashCode, numNode);
            }

            if (numNode == -1) {
                // not the same, should return;
                num = -1;
                break;
            } else {
                num += numNode;
                continue;
            }
        }

        int hashCodeRoot = hashCode(r1, r2);
        hash.put(hashCodeRoot, num);

        return num;
    }

    public static int hashCode(TreeNodeMultiChildren r1, TreeNodeMultiChildren r2) {
        int hash = r1.hashCode() * 31 + r2.hashCode();
        return hash;
    }

    public static void traversalTree(TreeNodeMultiChildren root, ArrayList<TreeNodeMultiChildren> ret) {
        if (root == null) {
            return;
        }

        ret.add(root);

        // add all the sub nodes.
        if (root.subNodes != null) {
            for(TreeNodeMultiChildren t: root.subNodes) {
                traversalTree(t, ret);
            }
        }
    }

}
