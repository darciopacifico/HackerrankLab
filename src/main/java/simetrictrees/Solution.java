package simetrictrees;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSimetric(root.left, root.right);
    }


    public boolean isSimetric(TreeNode l, TreeNode r) {

        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        //if (l.val != r.val) return false;


        Set<Integer> lVals = addVal(l);
        Set<Integer> rVals = addVal(r);

        if (!lVals.equals(rVals)) return false;

        return (isSimetric(l.left, l.right) && isSimetric(r.left, r.right))
                ||
                (isSimetric(r.left, l.right) && isSimetric(l.left, r.right));
    }

    private Set<Integer> addVal(TreeNode node) {
        Set<Integer> ints = new HashSet<>(2);
        if (node.left != null) {
            ints.add(node.left.val);
        }
        if (node.right != null) {
            ints.add(node.right.val);
        }
        return ints;
    }
}
