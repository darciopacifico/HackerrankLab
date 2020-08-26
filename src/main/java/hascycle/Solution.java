package hascycle;

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
        n4.next = n2;

        System.out.println(new Solution().hasCycle(root));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode t = head;
        ListNode h = head;

        do {
            if (h == null || h.next == null) return false;

            h = h.next.next;
            t = t.next;

        } while (t != h);

        return true;
    }
}
