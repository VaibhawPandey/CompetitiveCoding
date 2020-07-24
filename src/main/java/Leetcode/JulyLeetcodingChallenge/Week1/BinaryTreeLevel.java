package main.java.Leetcode.JulyLeetcodingChallenge.Week1;

import main.java.Leetcode.Chal30days.Week5.BinaryTreeMaxPath;
import main.java.Leetcode.JuneLeetcodingChallenge.Week4.CountCTN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevel {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        TreeNode leftNode = new TreeNode(9);
        leftNode.left = new TreeNode(5);
        TreeNode rightNode = new TreeNode(20);
        rightNode.left = new TreeNode(15);
        rightNode.right = new TreeNode(7);
        TreeNode root = new TreeNode(3, leftNode, rightNode);

        new BinaryTreeLevel().levelOrderBottom(root);
    }

    List<List<Integer>> out = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null)
            return out;

        getData(root, 0);

        return out;
    }

    private void getData(TreeNode root, int level) {

        if (root == null)
            return;

        if (out.size() <= level)
            out.add(0, new ArrayList<Integer>());

        out.get(out.size() - level - 1).add(root.val);
        if (root.left != null) getData(root.left, level + 1);
        if (root.right != null) getData(root.right, level + 1);
    }
}
