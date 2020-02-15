package minstack;

class MinStack {
    private Node top = null;

    private final static class Node {

        int value;
        int minValue;
        Node next;

        public Node(int value, int minValue, Node next) {
            this.value = value;
            this.minValue = minValue;
            this.next = next;
        }
    }

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        int minValue;

        if (top == null) {
            minValue = x;
        } else {
            minValue = Math.min(x, top.minValue);
        }

        top = new Node(x, minValue, top);
    }

    public void pop() {
        if (top != null) {
            this.top = this.top.next;
        }
    }

    public int top() {
        return this.top.value;
    }

    public int getMin() {
        return this.top.minValue;
    }
}