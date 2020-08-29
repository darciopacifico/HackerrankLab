package levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
class Solution {
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;

        List<List<Integer>> res = new Solution().levelOrder(n3);

        res.forEach(r -> {
            System.out.println();
            r.forEach(x -> System.out.print(x + ","));
        });
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res, 0);
        return res;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> res, int i) {
        if (root == null) return;

        List<Integer> level = getLevelList(res, i);
        level.add(root.val);

        levelOrder(root.left, res, i + 1);
        levelOrder(root.right, res, i + 1);
    }

    private List<Integer> getLevelList(List<List<Integer>> res, int i) {
        if (res.size() - 1 < i) {
            res.add(new LinkedList<>());
        }

        return res.get(i);
    }
}