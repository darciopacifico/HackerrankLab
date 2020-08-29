package binarytreeserializer;


import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

    public static void main(String[] args) {
        Codec codec = new Codec();

        String val;

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;

        t3.left = t4;
        t3.right = t5;

        val = codec.serialize(t1);

        TreeNode deserialized = codec.deserialize(val);

        System.out.println(val);
        System.out.println(codec.serialize(deserialized));
    }

    public String serialize(TreeNode root) {

        StringBuilder stringBuilder = new StringBuilder();
        serialize(stringBuilder, root);
        return stringBuilder.toString();
    }

    private void serialize(StringBuilder stringBuilder, TreeNode root) {
        if (root == null) {
            stringBuilder.append("n,");
        } else {
            stringBuilder.append(root.val).append(",");
            serialize(stringBuilder, root.left);
            serialize(stringBuilder, root.right);
        }
    }

    public TreeNode deserialize(String data) {

        String[] items = data.split(",");

        LinkedList<String> listItems = new LinkedList<>(Arrays.asList(items));

        return deserialize(listItems);

    }

    private TreeNode deserialize(LinkedList<String> listItems) {

        String item = listItems.removeFirst();

        if ("null".equals(item)) return null;

        TreeNode node = new TreeNode(new Integer(item));

        node.left = deserialize(listItems);
        node.right = deserialize(listItems);

        return node;
    }
}