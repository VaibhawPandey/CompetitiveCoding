package main.java.Leetcode.MayLeetcodingChallenge.Week1;

public class CousinsinBT {

    public static class TreeNode {
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

        TreeNode treeNode = new TreeNode(4, null, null);
        TreeNode leftNode = new TreeNode(2, treeNode, null);
        TreeNode rightNode = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, leftNode, rightNode);

        System.out.println(new CousinsinBT().isCousins(root, 4, 3));
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        return getLevel(root, x, 1) == getLevel(root, y, 1) &&
                (!isSiblings(root, x, y)); 
    }

    private boolean isSiblings(TreeNode root, int x, int y) {

        if (root == null)
            return false;

        if (root.left != null && root.right != null) {
            if ((root.left.val == x && root.right.val == y) ||
                    (root.left.val == y && root.right.val == x))
                return true;
        }

        return isSiblings(root.left, x, y) || isSiblings(root.right, x, y);
    }

    private int getLevel(TreeNode root, int item, int level) {
        
        if (root == null)
            return 0;

        if (root.val == item)
            return level;
        
        int leftLevel = getLevel(root.left, item, level + 1);

        if (leftLevel != 0)
            return leftLevel;

        return getLevel(root.right, item, level + 1);
    }
}
