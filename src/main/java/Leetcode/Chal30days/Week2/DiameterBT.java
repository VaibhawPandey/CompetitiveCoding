package main.java.Leetcode.Chal30days.Week2;

public class DiameterBT {

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        left1.left = new TreeNode(1);
        left1.right = null;
        right1.left = right1.right = null;

        left1.left = new TreeNode(4);
        left1.right = new TreeNode(5);
        left1.left.left = left1.left.right = left1.right.left = left1.right.right = null;

        head.left = left1; head.right = right1;
        System.out.println(new DiameterBT().diameterOfBinaryTree(head));

    }
    int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return result;
    }

    private int height(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        result = Math.max(result, 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
