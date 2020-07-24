package main.java.Leetcode.JuneLeetcodingChallenge.Week4;

public class RootSum {

    public static void main(String[] args) {
        CountCTN.TreeNode root = new CountCTN.TreeNode(4);
        CountCTN.TreeNode left = new CountCTN.TreeNode(9);
        left.left = new CountCTN.TreeNode(5);
        // left.right = new CountCTN.TreeNode(1);
        CountCTN.TreeNode right = new CountCTN.TreeNode(0);
        root.left = left; root.right = right;

        System.out.println(new RootSum().sumNumbers(root));

    }

    public int sumNumbers(CountCTN.TreeNode root) {

        if (root == null)
            return 0;

        return getSum(root,0);
    }

    private int getSum(CountCTN.TreeNode root, int sum) {

        if (root.left == null && root.right == null)
            return sum * 10 + root.val;

        int leftValue = root.left != null? getSum(root.left, sum * 10 + root.val): 0;
        int rightValue = root.right != null? getSum(root.right, sum * 10 + root.val): 0;

        return leftValue + rightValue;
    }
}
