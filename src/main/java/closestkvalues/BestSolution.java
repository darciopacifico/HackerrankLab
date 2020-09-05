package closestkvalues;

import java.util.LinkedList;
import java.util.List;

public class BestSolution {
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

        System.out.println(new BestSolution().closestKValues(n4, 4.12, 2));
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        inorder(ans, root, target, k);
        return ans;
    }

    public void inorder(LinkedList<Integer> ans, TreeNode root, double target, int k) {
        if (root != null) {
            inorder(ans, root.left, target, k);
            if (ans.size() < k) {
                ans.add(root.val);
            } else {
                if (Math.abs(target - ans.peek()) > Math.abs(target - root.val)) {
                    ans.poll();
                    ans.add(root.val);
                }
            }
            inorder(ans, root.right, target, k);
        }
    }
}