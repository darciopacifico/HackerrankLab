package pancakesorting;

import java.util.*;

import static java.util.Arrays.copyOf;
import static java.util.Arrays.sort;

public class Solution {
    public static void main(String[] args) {

        flipSequence(new int[]{10, 5, 1, 6, 3, 8, 2, 4, 7, 9});
        flipSequence(new int[]{3, 2, 4, 1});

//        3, 2, 4, 1
//        1  4  2  3
        //2  4  1  3
        //4  2  1  3
//
//
        flipSequence(new int[]{1, 2, 3, 4});

    }

    private static void flipSequence(int[] arr) {

        System.out.println();
        List<Integer> flips = new Solution().pancakeSort(arr);
        System.out.println();
        flips.forEach(f -> System.out.print(f + ","));
        System.out.println();
    }

    public List<Integer> pancakeSort(int[] arr) {

        final int[] goalArr = copyOf(arr, arr.length);
        sort(goalArr);

        final Object goalKey = getKey(goalArr);
        final String key = getKey(arr);

        if (goalKey.equals(key)) return Collections.emptyList();

        Map<String, Node> visited = new HashMap<>();


        PriorityQueue<Node> queue = new PriorityQueue<>(getComparator(key));
        queue.add(new Node(key, arr, 0, 0, null));

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (goalKey.equals(node.key)) return toFlipList(node.previousNode);

            //for (int j = 1; j < arr.length; j++) {
            for (int j = arr.length - 1; j >= 1; j--) {

                if (arr[j] == j + 1) continue;

                Node newNode = getNewNode(node, j);

                if (goalKey.equals(newNode.key)) {
                    return toFlipList(newNode);
                }

                if (!visited.containsKey(newNode.key)) {
                    visited.put(newNode.key, newNode);
                    queue.add(newNode);
                }

            }
        }

        throw new IllegalArgumentException("there is no possible solution");
    }

    private Comparator<Node> getComparator(String key) {

        return new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                int o1Dist = getDistance(o1, key);
                int o2Dist = getDistance(o2, key);

                return o1Dist - o2Dist;
            }

            private int getDistance(Node node, String key) {
                //return node.distance;
                int distanceFromIdeal = 0;
                for (int i = 0; i < key.length(); i++) {
                    int distance = Math.abs((i + 1) - node.arr[i]);
                    distanceFromIdeal -= distance;
                }
                return distanceFromIdeal;
            }
        };

    }

    private List<Integer> toFlipList(Node node) {

        LinkedList<Integer> res = new LinkedList<>();
        while (node != null) {

            for (int i = 0; i < node.arr.length; i++) {
                System.out.print(node.arr[i] + ",");
            }
            System.out.print("  flip 0 to " + node.j);
            System.out.println();

            if (node.j != 0)
                res.addFirst(node.j + 1);
            node = node.previousNode;
        }

        return res;
    }

    private Node getNewNode(Node previousNode, int j) {
        int[] newArr = copyOf(previousNode.arr, previousNode.arr.length);
        int jCopy = j;
        int i = 0;
        while (i < j) {
            int temp = newArr[i];
            newArr[i] = newArr[j];
            newArr[j] = temp;
            i++;
            j--;
        }

        return new Node(getKey(newArr), newArr, previousNode.distance + 1, jCopy, previousNode);
    }

    class Node {
        public String key;
        public int[] arr;
        public int distance;
        public int j;
        public Node previousNode;

        public Node(String key, int[] arr, int distance, int j, Node previousNode) {
            this.key = key;
            this.arr = arr;
            this.distance = distance;
            this.j = j;
            this.previousNode = previousNode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    private String getKey(int[] arr) {
        char[] c = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            c[i] = (char) ((int) '0' + arr[i]);
        }
        return new java.lang.String(c);
    }
}
