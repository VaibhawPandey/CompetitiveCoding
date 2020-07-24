package main.java.Leetcode.JulyLeetcodingChallenge.Week4;

import java.util.ArrayList;
import java.util.List;

public class BTZigzagLOT {

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
    }

    List<List<Integer>> out;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        out = new ArrayList<>();
        levelOrderTraversal(root, 0);

        return out;
    }

    private void levelOrderTraversal(TreeNode root, int level) {

        if (out.size() == level) {
            List<Integer> res = new ArrayList<>();
            res.add(root.val);
            out.add(res);
        } else {

            if (level % 2 == 0)
            out.get(level).add(0, root.val);
            else
                out.get(level).add(root.val);
        }

        if (root.left != null) levelOrderTraversal(root.left, level + 1);
        if (root.right != null) levelOrderTraversal(root.right, level + 1);
    }
}
