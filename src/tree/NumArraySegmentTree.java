package tree;

/**
 * Created by shuxuannie on 7/17/16.
 *
 * Range Sum Query - Mutable
 *
 * 307. Range Sum Query - Mutable  QuestionEditorial Solution  My Submissions
 Total Accepted: 14963
 Total Submissions: 81888
 Difficulty: Medium
 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.
 Example:
 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:
 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.
 Hide Tags Segment Tree Binary Indexed Tree
 Hide Similar Problems (E) Range Sum Query - Immutable (H) Range Sum Query 2D - Mutable

 *
 *
 */
public class NumArraySegmentTree {

    private SegmentTreeNode root;

    public NumArraySegmentTree(int[] nums) {
        this.root = buildTree(nums, 0, nums.length-1);
    }

    public void update(int i, int val) {
        updateHelper(this.root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(this.root, i, j + 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int begin, int end) {
        if (nums == null || nums.length == 0 || begin > end)
            return null;
        if (begin == end) // one element
            return new SegmentTreeNode(begin, end, nums[begin]);

        SegmentTreeNode root = new SegmentTreeNode(begin, end);
        int middle = begin + (end - begin) / 2;
        root.left = buildTree(nums, begin, middle);
        root.right = buildTree(nums, middle+1, end);
        root.sum = root.left.sum + root.right.sum;

        return root;
    }

    private void updateHelper(SegmentTreeNode root, int i, int val) {
        if (root.begin == root.end && root.begin == i) {
            root.sum = val;
            return;
        }

        int middle = root.begin + (root.end - root.begin) / 2;
        if (i <= middle) {
            updateHelper(root.left, i, val);
        } else {
            updateHelper(root.right, i, val);
        }

        root.sum = root.left.sum + root.right.sum;
    }
    private int sumRangeHelper(SegmentTreeNode root, int begin, int end) {
        if (root == null || begin >root.end || end < root.begin)
            return 0;
        if (begin <= root.begin && end >= root.end)
            return root.sum;

        int middle = root.begin + (root.end - root.begin) / 2;
        return sumRangeHelper(root.left, begin, middle) +
                sumRangeHelper(root.right, middle+1, end);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};

        NumArraySegmentTree obj = new NumArraySegmentTree(nums);

    }
}
