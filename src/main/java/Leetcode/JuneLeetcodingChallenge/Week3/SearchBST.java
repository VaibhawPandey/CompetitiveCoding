package main.java.Leetcode.JuneLeetcodingChallenge.Week3;

public class SearchBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode searchBST(TreeNode root, int val) {

        TreeNode currNode = new TreeNode();

        if (root == null)
            return null;

        currNode = root;
        while (currNode != null && currNode.val != val) {
            if (currNode.val > val)
                currNode = currNode.left;
            else
                currNode = currNode.right;
        }

        return currNode;
    }
}
