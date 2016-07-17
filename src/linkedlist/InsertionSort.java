package linkedlist;

/**
 * Created by shuxuannie on 7/12/16.
 *
 * Sort a linked list using insertion sort.

 Show Tags
 Show Similar Problems

 */
public class InsertionSort {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);

        while (head != null) {
            ListNode node = dummy;
            //队列分为2部分，排序的和非排序的，head指向非排序的头，node指向比head大的前一个元素，把head插入到node之后
            //node找到node的后一个元素比head大，node指向比第一个比head大的元素之前，这样就可以把head插入到node之后，
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            //每次从头开始往后找到需要插入的位置，然后把head插入到node之后。
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummy.next;
    }
}
