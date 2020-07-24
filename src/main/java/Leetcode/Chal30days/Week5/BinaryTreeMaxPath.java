package main.java.Leetcode.Chal30days.Week5;

public class BinaryTreeMaxPath {

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
    public static void main(String[] args) {

        TreeNode root = new BinaryTreeMaxPath().getTreeNode();
        System.out.println(new BinaryTreeMaxPath().maxPathSum(root));
    }

    private TreeNode getTreeNode() {
        TreeNode node1 = new TreeNode(9, null, null);
        TreeNode node2 = new TreeNode(15, null, null);
        TreeNode node3 = new TreeNode(7, null, null);
        TreeNode rightNode = new TreeNode(20, node2, node3);
        return new TreeNode(-10, node1, rightNode);
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return maxSum;
    }

    private int getMaxSum(TreeNode root) {
         if (root == null)
             return 0;

         int leftSum = getMaxSum(root.left);
         int rightSum = getMaxSum(root.right);

         if (leftSum < 0)
             leftSum = 0;
         if (rightSum < 0)
             rightSum = 0;

         maxSum = Math.max(maxSum, leftSum + rightSum + root.val);

         return Math.max(leftSum, rightSum) + root.val;
    }
}
