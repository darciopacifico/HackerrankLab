package closestkvalues;

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

        Solution kclosest = new Solution();

        List<Integer> inOrderItems = kclosest.closestKValues(n4, 4.23, 1);
        inOrderItems.forEach(System.out::println);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        LinkedList<Integer> greater = new LinkedList<>();
        LinkedList<Integer> lower = new LinkedList<>();

        inorderTraversal(root, greater, lower, target, k);

        List<Integer> results = new LinkedList<>();

        while (results.size() < k && (!lower.isEmpty() || !greater.isEmpty())) {

            if (!lower.isEmpty() && !greater.isEmpty()) {

                double l = Math.abs(target - lower.getFirst());
                double g = Math.abs(target - greater.getFirst());

                if (l < g) {
                    results.add(lower.removeFirst());
                } else {
                    results.add(greater.removeFirst());
                }

            } else if (!lower.isEmpty()) {
                results.add(lower.removeFirst());
            } else if (!greater.isEmpty()) {
                results.add(greater.removeFirst());
            }

        }

        return results;
    }

    private void inorderTraversal(TreeNode root, LinkedList<Integer> greater, LinkedList<Integer> lower, double target, int k) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while ((cur != null || !stack.isEmpty()) ) {

            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();

            if (node.val <= target) {
                lower.addFirst(node.val);
            } else if (node.val > target) {
                greater.add(node.val);
            }

            if (node.right != null) {
                cur = node.right;
            }

        }

    }

}