/**
 * Created by jiaqi on 2019/6/6 12:13 AM
 * <p>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class P21_MergeTwoSortedLists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode(0);
        ListNode p = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0), p1 = node1;
        ListNode node2 = new ListNode(0), p2 = node2;
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        for (int i = 0; i < arr1.length; i++) {
            p1.next = new ListNode(arr1[i]);
            p1 = p1.next;
        }
        for (int i = 0; i < arr2.length; i++) {
            p2.next = new ListNode(arr2[i]);
            p2 = p2.next;
        }

        ListNode node = mergeTwoLists(node1.next, node2.next);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
