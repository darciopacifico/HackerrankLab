package diameterbintree;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    private boolean visitedLeft;
    private boolean visitedRight;

    public static void main(String[] args) {
        {

            TreeNode root1 = new TreeNode(1);
            TreeNode root2 = new TreeNode(2);
            TreeNode root3 = new TreeNode(3);
            TreeNode root4 = new TreeNode(4);
            TreeNode root5 = new TreeNode(5);

            root1.left = root2;
            root1.right = root3;
            root2.left = root4;
            root2.right = root5;

            System.out.println(new Solution().diameterOfBinaryTree(root1));
        }
        {
            TreeNode root1 = new TreeNode(1);
            TreeNode root2 = new TreeNode(2);
            TreeNode root3 = new TreeNode(3);
            root1.left = root2;
            root2.right = root3;
            System.out.println(new Solution().diameterOfBinaryTree(root1) + " must be 2");
        }
        {
            TreeNode root1 = new TreeNode(1);
            TreeNode root2 = new TreeNode(2);
            root1.left = root2;
            System.out.println(new Solution().diameterOfBinaryTree(root1) + " must be 1");
        }
        System.out.println(new Solution().diameterOfBinaryTree(null));
    }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }


}
