/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * 需要注意末尾进位的问题
 */

public class P2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(2);

        ListNode res = addTwoNumbers2(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode p = node;
        int r = 0, temp;
        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val + r;
            r = 0;
            if (temp > 9) {
                r = temp / 10;
                temp %= 10;
            }
            p.next = new ListNode(temp);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            if (r > 0) {
                p.next = new ListNode(r);
            }
        }

        if (l1 != null) {
            while (l1 != null) {
                temp = l1.val + r;
                r = 0;
                if (temp > 9) {
                    r = temp / 10;
                    temp %= 10;
                }
                p.next = new ListNode(temp);
                p = p.next;
                l1 = l1.next;
            }
            if (r > 0) {
                p.next = new ListNode(r);
            }
        }

        if (l2 != null) {
            while (l2 != null) {
                temp = l2.val + r;
                r = 0;
                if (temp > 9) {
                    r = temp / 10;
                    temp %= 10;
                }
                p.next = new ListNode(temp);
                p = p.next;
                l2 = l2.next;
            }
            if (r > 0) {
                p.next = new ListNode(r);
            }
        }

        return node.next;
    }


    // 改进
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode p = node;
        int r = 0, res;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            res = x + y + r;
            r = 0;
            if (res > 9) {
                r = res / 10;
                res %= 10;
            }
            ListNode t = new ListNode(res);
            p.next = t;
            p = p.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (r > 0) {
            p.next = new ListNode(r);
        }
        return node.next;

    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
