package countcompletenodes;

public class Solution {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        System.out.println(new Solution().countNodes(n1));
    }


    public int countNodes(TreeNode node) {
        if (node != null) {
            return 1 + countNodes(node.left) + countNodes(node.right);
        } else {
            return 0;
        }
    }
}
