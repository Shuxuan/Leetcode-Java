package linkedlist;

/**
 * Created by shuxuannie on 7/5/16.
 */
public class ReverseKLinkedList {

    public ReverseKLinkedList() {
        // TODO Auto-generated constructor stub
    }

    public static ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseK(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode preEnd = dummy;

        ListNode cur = head;
        while (cur != null) {
            int count = k;
            ListNode begin = cur;
            ListNode pre = null;
            while (count-- > 0 && cur != null ) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            preEnd.next = pre;
            preEnd = begin;
        }
        // get

        return dummy.next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        ListNode newHead = ReverseKLinkedList.reverse(head);
        int k = 2;
        newHead = ReverseKLinkedList.reverseK(newHead, 2);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }



}
