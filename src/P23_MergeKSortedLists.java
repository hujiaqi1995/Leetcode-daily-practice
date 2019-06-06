import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jiaqi on 2019/6/6 5:14 PM
 * <p>
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class P23_MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        list.sort(Comparator.naturalOrder());
        ListNode n = new ListNode(0), p = n;
        for (int i : list) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return n.next;
    }

    // 这个性能更差了…… 遍历所有链表只添加了一个元素
    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode node = new ListNode(0), p = node;
        boolean isEmpty = false;
        int min, len, index;
        while (!isEmpty) {
            min = Integer.MAX_VALUE;
            len = 0;
            index = 0;
            for (int i = 0; i < lists.length; i++) {
                if (len == lists.length) {
                    isEmpty = true;
                    break;
                }
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        index = i;
                    }
                } else {
                    len++;
                }
            }
            if (len == lists.length) {
                return node.next;
            }
            p.next = lists[index];
            p = p.next;
            lists[index] = lists[index].next;
        }
        return node.next;
    }

    // 看到别人用了归并排序……
    public static ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length < 2) return lists[0];
        return split(lists, 0, lists.length-1);
    }

    private static ListNode split(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[end];
        int mid = (start + end) / 2;
        ListNode left = split(lists, start, mid);
        ListNode right = split(lists, mid+1,end);
        return merge(left, right);
    }

    private static ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        ListNode head = new ListNode(0), p = head;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }

        if (n1 != null) {
            p.next = n1;
        }
        if (n2 != null) {
            p.next = n2;
        }
        return head.next;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5};
        int[] arr2 = {1, 3, 4};
        int[] arr3 = {2, 6};
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);
        ListNode p1 = node1, p2 = node2, p3 = node3;
        for (int i = 0; i < arr1.length; i++) {
            p1.next = new ListNode(arr1[i]);
            p1 = p1.next;
        }
        for (int i = 0; i < arr2.length; i++) {
            p2.next = new ListNode(arr2[i]);
            p2 = p2.next;
        }
        for (int i = 0; i < arr3.length; i++) {
            p3.next = new ListNode(arr3[i]);
            p3 = p3.next;
        }

        ListNode[] arr = {node1.next, node2.next, node3.next};
        ListNode n = mergeKLists3(arr);

        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

}
