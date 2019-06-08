import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiaqi on 2019/6/8 10:49 PM
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class P25_ReverseNodesInKGroup {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        ListNode cur = fakeNode;
        while (head != null) {
            stack.push(head);
            head = head.next;
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    cur.next = stack.pop();
                    cur = cur.next;
                }
            }
        }
        if (stack.isEmpty()) {
            cur.next = null;
        } else {
            cur.next = stack.getLast();
        }
        return fakeNode.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode head = new ListNode(0), p = head;
        for (int i = 0; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        ListNode node = reverseKGroup(head.next, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
