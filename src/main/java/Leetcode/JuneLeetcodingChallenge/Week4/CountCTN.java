package main.java.Leetcode.JuneLeetcodingChallenge.Week4;

import java.util.List;

public class CountCTN {
    public static void main(String[] args) {



    }

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

    int count = 0;

    public int countNodes(TreeNode root) {

        if (root == null)
            return count;
        count++;

        countNodes(root.left);
        countNodes(root.right);

        return count;
    }
}
