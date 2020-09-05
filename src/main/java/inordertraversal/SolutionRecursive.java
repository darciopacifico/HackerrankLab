package inordertraversal;

import java.util.LinkedList;
import java.util.List;

class SolutionRecursive {
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

        SolutionRecursive solutionRecursive = new SolutionRecursive();

        List<Integer> inOrderItems = solutionRecursive.inorderTraversal(n4);

        inOrderItems.forEach(System.out::println);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> inOrderValues = new LinkedList<>();
        inorderTraversal(root, inOrderValues);
        return inOrderValues;
    }

    private void inorderTraversal(TreeNode root, LinkedList<Integer> integers) {
        if (root == null) return;
        inorderTraversal(root.left, integers);
        integers.add(root.val);
        inorderTraversal(root.right, integers);
    }
}