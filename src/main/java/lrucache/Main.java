package lrucache;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);


    }

    public static class LRUCache {

        private final int capacity;

        private HashMap<Integer, Node> cache = new HashMap();
        private Node top = new Node(-1, -1);
        private Node bot = new Node(-1, -1);


        public LRUCache(int capacity) {
            this.capacity = capacity;

            this.top.below = bot;
            this.bot.above = top;
        }

        public int get(int key) {

            Node node = cache.get(key);

            if (node == null)
                return -1;


            moveToHead(node);

            return node.value;
        }

        private void moveToHead(Node node) {


            //top
            //node
            //bot

            removeFromLinkedList(node);

            addBelowTop(node);

        }

        private void addBelowTop(Node node) {
            Node belowTop = top.below;

            top.below = node;
            node.above = top;
            node.below = belowTop;
            belowTop.above = node;
        }

        private void removeFromLinkedList(Node node) {
            Node above = node.above;
            Node below = node.below;

            above.below = below;
            below.above = above;
        }


        public void put(int key, int value) {

            Node node = cache.get(key);
            if (node!=null) {
                node.value = value;
                moveToHead(node);
            } else {

                Node newNode = new Node(key, value);

                cache.put(key, newNode);

                if (cache.size() > capacity) {
                    dropLRUNode();
                }

                addBelowTop(newNode);

            }

            //return "put key:" + key + " val:" + value;
        }

        private void dropLRUNode() {
            // drop lr node
            //y
            //lrNode
            //bot

            Node lrNode = bot.above;
            Node y = lrNode.above;
            y.below = bot;
            bot.above = y;
            lrNode.above = null;
            lrNode.below = null;
            cache.remove(lrNode.key);
        }


        class Node {
            public final int key;
            public int value;
            public Node above;
            public Node below;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;

            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
