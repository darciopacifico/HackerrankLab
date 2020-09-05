package inordertraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n4.left = n3;
        n3.left = n2;
        n2.left = n1;

        n4.right = n6;
        n6.left = n5;
        n6.right = n7;

        Solution solutionRecursive = new Solution();

        List<Integer> inOrderItems = solutionRecursive.inorderTraversal(n4);

        inOrderItems.forEach(System.out::println);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> inOrderValues = new LinkedList<>();
        inorderTraversal(root, inOrderValues);
        return inOrderValues;
    }

    private void inorderTraversal(TreeNode root, LinkedList<Integer> integers) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();

            integers.add(node.val);

            if (node.right != null) {
                cur = node.right;
            }

        }

    }
}