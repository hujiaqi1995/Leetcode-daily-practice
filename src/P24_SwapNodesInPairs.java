/**
 * Created by jiaqi on 2019/6/7 10:15 PM
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class P24_SwapNodesInPairs {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h, cur = head, next = null;
        while (cur != null && cur.next != null) {
            next = cur.next;
            ListNode temp = next.next;
            next.next = cur;
            cur.next = temp;
            pre.next = next;
            pre = cur;
            cur = temp;
        }

        return h.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        ListNode res = swapPairs(head.next);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
