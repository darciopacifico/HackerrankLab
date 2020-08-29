package codectree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Codec {

    public static void main(String[] args) {

        test("[1,null,3,2,4,null,5,6]");
        test("[]");
    }

    private static void test(String serialized) {
        Codec codec = new Codec();
        Node deserialized = codec.deserialize(serialized);
        System.out.println(deserialized);

        String postSerialized = codec.serialize(deserialized);

        System.out.println("success: " + (postSerialized.equals(serialized)));
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "[]";

        Node dummy = new Node(-1, new LinkedList<>());
        dummy.children.add(root);

        Queue<Node> queue = new LinkedList<>();
        queue.add(dummy);

        StringBuilder serialized = new StringBuilder();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node child : node.children) {
                serialized.append(child.val).append(",");
                queue.add(child);
            }
            serialized.append("null,");
        }
        serialized.deleteCharAt(serialized.length()-1);

        return "["+serialized.toString()+"]";

    }

    public <E> String toString(List<E> list) {
        Iterator<E> it = list.iterator();
        if (!it.hasNext())
            return "";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',');
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        data = data.substring(1, data.length() - 1);

        String[] nodesStr = data.split(",");
        if (data.isEmpty()) return null;

        Node dummy = new Node(-1, new LinkedList<>());
        Queue<Node> q = new LinkedList<>();
        q.add(dummy);

        int i = 0;

        while (!q.isEmpty()) {
            Node parent = q.poll();
            Node child;
            while ((child = getNode(nodesStr, i++)) != null) {
                parent.children.add(child);
                q.add(child);
            }

        }
        return dummy.children.isEmpty() ? null : dummy.children.get(0);
    }


    private Node getNode(String[] nodesStr, int i) {
        if (i >= nodesStr.length) return null;

        String nStr = nodesStr[i];
        Node node = null;
        if (nStr!=null && !nStr.isEmpty() && !nStr.equals("null")) {
            node = new Node(parseInt(nStr), new LinkedList<>());
        }
        return node;
    }
}