package fb_minoperations;

import java.util.*;

import static java.util.Arrays.copyOf;
import static java.util.Arrays.sort;

class Main {
    int minOperations(int[] arr) {
        // Write your code here

        final int[] goalArr = copyOf(arr, arr.length);
        sort(goalArr);

        final Object goalKey = getKey(goalArr);
        final Object key = getKey(arr);

        if (goalKey.equals(key)) return 0;

        Map<Object, Node> visited = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(key, arr, 0));

        while (!queue.isEmpty()) {

            Node node = queue.remove();
            if (goalKey.equals(node.key)) return node.distance;

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    Node newNode = getNewNode(node, i, j);

                    if (goalKey.equals(newNode.key)) {
                        return newNode.distance;
                    }

                    if (!visited.containsKey(newNode.key)) {
                        visited.put(newNode.key, newNode);
                        queue.add(newNode);
                    } else {
                        Node sameNode = visited.get(newNode.key);
                        if (sameNode.distance > newNode.distance) {
                            sameNode.distance = newNode.distance;
                            queue.add(sameNode);
                        }
                    }

                }
            }
        }

        return -1;
    }

    private Node getNewNode(Node node, int i, int j) {
        int[] newArr = copyOf(node.arr, node.arr.length);
        while (i < j) {
            int temp = newArr[i];
            newArr[i] = newArr[j];
            newArr[j] = temp;
            i++;
            j--;
        }
        return new Node(getKey(newArr), newArr, node.distance + 1);
    }

    class Node {
        public Object key;
        public int[] arr;
        public int distance;

        Node(Object key, int[] arr, int distance) {
            this.key = key;
            this.arr = arr;
            this.distance = distance;
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

    private Object getKey(int[] arr) {
        char[] c = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            c[i] = (char) ((int) '0' + arr[i]);
        }
        return new java.lang.String(c);
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}