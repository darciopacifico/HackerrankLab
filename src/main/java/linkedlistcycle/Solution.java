package linkedlistcycle;

public class Solution {
    public static void main(String[] args) {
        ListNode root = new ListNode(-1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n0 = new ListNode(0);
        ListNode n4 = new ListNode(4);

        root.next = n3;
        n3.next = n2;
        n2.next = n0;
        n0.next = n4;
        //n4.next = n2;

        ListNode listNode = new Solution().detectCycle(root);
        System.out.println(listNode != null ? listNode.val : null);
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public ListNode detectCycle(ListNode head) {

        ListNode h = head;
        ListNode t = head;

        do {
            h = next(next(h));
            t = next(t);
            if (h == null || t == null) return null; // no cycle
        } while (h != t);

        h = head;
        do {
            h = next(h);
            t = next(t);
            if (h == null || t == null) return null; // no cycle
        } while (h != t);

        return t;
    }

    private ListNode next(ListNode head) {
        return head != null ? head.next : null;
    }
}
