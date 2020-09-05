package reverselinkedlist;

public class Solution {
    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode n1 = head;
        for (int i = 1; i < 4; i++) {
            ListNode n2 = new ListNode(i);
            n1.next = n2;
            n1 = n2;
        }

        ListNode newHead = new Solution().reverseList(head);

        System.out.println(newHead);
    }

    public ListNode reverseList(ListNode head) {
        //return reverseIterStack(head);
        //return reverseRecur(head);
        return reverseIter(head);
    }


    private ListNode reverseRecur(ListNode node) {
        if (node == null) return null;
        if (node.next == null) return node;
        ListNode tail = reverseRecur(node.next);

        node.next.next = node;
        node.next = null;

        return tail;
    }

    private ListNode reverseIter(ListNode node) {
        ListNode previous = null;
        ListNode current = node;

        while(current!=null){
            ListNode nextTemp = current.next;

            current.next = previous;

            previous=current;
            current = nextTemp;

        }
        return previous;
    }

}