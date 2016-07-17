package linkedlist;

/**
 * Created by shuxuannie on 7/12/16.
 *
 *
 * 369. Plus One Linked List  QuestionEditorial Solution  My Submissions
 Total Accepted: 1625
 Total Submissions: 3336
 Difficulty: Medium
 Given a non-negative number represented as a singly linked list of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Input:
 1->2->3

 Output:
 1->2->4

 */
public class PlusOne {
    public ListNode plusOne(ListNode head) {
        ListNode new_head = reverse(head);

        ListNode cur = new_head;

        int carry = (cur.val + 1) / 10;
        cur.val = (cur.val + 1) % 10;
        ListNode pre = cur;
        cur = cur.next;

        while (cur != null) {
            int value = (cur.val + carry) % 10;
            carry = (cur.val + carry) / 10;
            cur.val = value;
            pre = cur;
            cur = cur.next;
        }

        if (carry == 1) {
            ListNode new_tail = new ListNode(1);
            pre.next = new_tail;
        }

        new_head = reverse(new_head);
        return new_head;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(9);
        PlusOne obj = new PlusOne();
        node = obj.plusOne(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
