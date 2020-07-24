package main.java.Leetcode.MayLeetcodingChallenge.Week4;

public class ConstructBST {

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

        new ConstructBST().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++)
            root = insertRec(root, preorder[i]);

        return root;
    }

    private TreeNode insertRec(TreeNode root, int val) {

        if (root == null) {
            root = new TreeNode(val, null, null);
            return root;
        }

        if (val < root.val)
            root.left = insertRec(root.left, val);
        else
           if (val > root.val)
              root.right = insertRec(root.right, val);

        return root;
    }
}
