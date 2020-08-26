package zigzagtraversal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private boolean debug = true;

    /**
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param args
     */

    public static void main(String[] args) {
    /*        {
                TreeNode t3 = new TreeNode(3);
                TreeNode t9 = new TreeNode(9);
                TreeNode t20 = new TreeNode(20);
                TreeNode t15 = new TreeNode(15);
                TreeNode t7 = new TreeNode(7);

                t3.left = t9;
                t3.right = t20;

                t20.left = t15;
                t20.right = t7;

                printRes(new Solution().zigzagLevelOrder(t3));
            }*/
        {
            TreeNode t1 = new TreeNode(1);
            TreeNode t2 = new TreeNode(2);
            TreeNode t3 = new TreeNode(3);
            TreeNode t4 = new TreeNode(4);
            TreeNode t5 = new TreeNode(5);

            t1.left = t2;
            t1.right = t3;

            t2.left = t4;
            t3.right = t5;

            printRes(new Solution().zigzagLevelOrder(t1));
        }
    }

    private static void printRes(List<List<Integer>> res) {
        for (List<Integer> r : res) {
            System.out.println();
            for (Integer i : r) {
                System.out.print(i + ", ");
            }

        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root != null) {
            Deque<TreeNodeLevel> q = new LinkedList<>();
            q.add(new TreeNodeLevel(0, root));
            zigzagIt(q, res);
        }

        return res;
    }

    final static class TreeNodeLevel {
        private final int level;
        private final TreeNode treeNode;

        public TreeNodeLevel(int level, TreeNode treeNode) {
            this.level = level;
            this.treeNode = treeNode;
        }
    }

    private void zigzagIt(Deque<TreeNodeLevel> q, List<List<Integer>> res) {
        if (q.isEmpty()) return;
        TreeNodeLevel tn = q.poll();

        int newLevel = tn.level;

        if (newLevel >= res.size())
            res.add(new LinkedList<>());

        Deque<Integer> integers = (Deque<Integer>) res.get(newLevel);
        if (newLevel % 2 != 0) {
            integers.addFirst(tn.treeNode.val);
        } else {
            integers.addLast(tn.treeNode.val);
        }

        ++newLevel;

        if (tn.treeNode.left != null)
            q.add(new TreeNodeLevel(newLevel, tn.treeNode.left));

        if (tn.treeNode.right != null)
            q.add(new TreeNodeLevel(newLevel, tn.treeNode.right));

        zigzagIt(q, res);

    }
}
