package zigzagtraversalbest;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root != null) {
            zigzagLevelOrder(root, res, 0);
        }

        return res;
    }

    private void zigzagLevelOrder(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;

        if (res.size() == level) res.add(new LinkedList<>());

        LinkedList<Integer> integers = (LinkedList<Integer>) res.get(level);
        if (level % 2 == 0) {
            integers.addLast(root.val);
        } else {
            integers.addFirst(root.val);
        }

        zigzagLevelOrder(root.left, res, level + 1);
        zigzagLevelOrder(root.right, res, level + 1);
    }

}
