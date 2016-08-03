package tree;

/**
 * Created by shuxuannie on 7/17/16.
 */
public class SegmentTreeNode {
    int begin;
    int end;
    int sum;
    SegmentTreeNode left;
    SegmentTreeNode right;

    public SegmentTreeNode(int begin, int end) {
        this.begin = begin;
        this.end = end;
        this.sum = 0;
    }

    public SegmentTreeNode(int begin, int end, int sum) {
        this.begin = begin;
        this.end = end;
        this.sum = sum;
    }
}
