package reverse;

// Add any extra import statements you may need here


class Main {

    class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Add any helper functions you may need here
    Node reverse(Node head) {
        // Write your code here
        Node previous = null;
        Node current = head;

        while (current != null) {

            Node lastElement;
            if (isEven(current.data)) {
                Node nextOdd = getNextOdd(current.next);
                Node firstElement = revert(previous, current);
                lastElement = getLast(firstElement);
                if(previous==null){
                    head=firstElement;
                }
                lastElement.next = nextOdd;
                previous = lastElement;
                current = nextOdd;
            } else {
                previous = current;
                current = current.next;
            }

        }

        return head;
    }

    private Node getNextOdd(Node next) {
        if (next == null || !isEven(next.data)) return next;
        return getNextOdd(next.next);
    }

    private Node revert(Node previous, Node current) {
        if (previous != null)
            previous.next = null;
        Node lastEven = revertEvens(current);
        if (previous != null)
            previous.next = lastEven;
        return lastEven;
    }

    private Node getLast(Node lastEven) {
        if (lastEven == null || lastEven.next == null) return lastEven;
        return getLast(lastEven.next);
    }

    private Node revertEvens(Node current) {
        if (current == null || current.next == null || !isEven(current.next.data)) return current;
        Node lastEven = revertEvens(current.next);

        current.next.next = current;
        current.next = null;

        return lastEven;
    }


    private boolean isEven(int data) {
        return data % 2 == 0;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void printLinkedList(Node head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }

    void check(Node expectedHead, Node outputHead) {
        boolean result = true;
        Node tempExpectedHead = expectedHead;
        Node tempOutputHead = outputHead;
        while (expectedHead != null && outputHead != null) {
            result &= (expectedHead.data == outputHead.data);
            expectedHead = expectedHead.next;
            outputHead = outputHead.next;
        }
        if (!(expectedHead == null && outputHead == null)) result = false;

        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printLinkedList(tempExpectedHead);
            System.out.print(" Your output: ");
            printLinkedList(tempOutputHead);
            System.out.println();
        }
        test_case_number++;
    }

    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    public void run() {

        /*
        int[] arr_1 = {1, 2, 8, 9, 12, 16};
        int[] expected1 = {1, 8, 2, 9, 16, 12};
        Node head_1 = createLinkedList(arr_1);
        Node expected_1 = createLinkedList(expected1);
        Node output_1 = reverse(head_1);
        check(expected_1, output_1);
        */
        int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        Node head_2 = createLinkedList(arr_2);
        Node expected_2 = createLinkedList(expected2);
        Node output_2 = reverse(head_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}