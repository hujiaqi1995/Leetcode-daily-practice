import java.util.List;

/**
 * Created by jiaqi on 2019/6/4 10:20 PM
 */
public class P19_RemoveNthNodeFromEndofList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode before = head, after = head, p = after;
        while (n-- > 0 && before != null) {
            before = before.next;
        }
        if (before == null) {
            // 删除第一个
            return after.next;
        }
        while (before.next != null) {
            before = before.next;
            after = after.next;
        }
        after.next = after.next.next;
        return p;
    }


    public static void main(String[] args) {
        int[] arr = {1,2};
        ListNode head = new ListNode(0), p = head;
        for (int i = 0; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        ListNode node = removeNthFromEnd(head.next, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
