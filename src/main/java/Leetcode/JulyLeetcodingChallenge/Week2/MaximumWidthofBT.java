package main.java.Leetcode.JulyLeetcodingChallenge.Week2;

import java.util.*;

public class MaximumWidthofBT {

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

    public static TreeNode insertLevelOrder(int[] arr, TreeNode root,
                                     int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }

    public static void main(String[] args) {

//        TreeNode left = new TreeNode(3, new TreeNode(5), new TreeNode(3));
//        TreeNode right = new TreeNode(2, null, new TreeNode(9));
//        TreeNode root = new TreeNode(1, left, right);

        //TreeNode root = new TreeNode();
        //root = insertLevelOrder(new int[]{1,1,1,1,1,1,1,null,null,null,1,null,null,null,null,2,2,2,2,2,2,2,null,2,null,null,2,null,2}, root, 0);

        TreeNode root = new TreeNode(1);

        System.out.println(new MaximumWidthofBT().widthOfBinaryTree(root));
    }

    public int widthOfBinaryTree(TreeNode root) {

        List<Integer> lefts = new ArrayList<>();
        return dfs(root, 1, 0, lefts);
    }

    private int dfs(TreeNode root, int id, int d, List<Integer> lefts) {

        if (root == null) return 0;
        if (d >= lefts.size()) lefts.add(id);
        return Math.max(id + 1 - lefts.get(d), Math.max(dfs(root.left, 2 * id, d+1, lefts), dfs(root.right, 2*id + 1, d+1, lefts)));
    }


//    public int widthOfBinaryTree(TreeNode root) {
//
//        int maxWidth = 0;
//
//        if (root == null)
//            return maxWidth;
//
//        int height = getHeight(root, 0);
//
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        maxWidth = 1;
//
//        while (!queue.isEmpty() && height >= 0) {
//
//            int size = queue.size();
//            int tempCount = size;
//            int leftIndex = Integer.MIN_VALUE;
//            while (tempCount-- > 0) {
//
//                TreeNode node = queue.remove();
//
//                if (node == null) {
//                    queue.add(null);
//                    queue.add(null);
//                } else {
//                    if (leftIndex == Integer.MIN_VALUE) leftIndex = size - tempCount;
//                    else {
//                        int rightIndex = size - tempCount;
//                        maxWidth = Math.max(maxWidth, rightIndex - leftIndex);
//                    }
//                    queue.add(node.left);
//                    queue.add(node.right);
//                }
//            }
//
//            height--;
//        }
//
//        return maxWidth;
//    }

    private int getHeight(TreeNode root, int level) {

        if (root.left == null && root.right == null)
            return level;

        // height = Math.max(height, level);
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;

        if (root.left != null) left = getHeight(root.left, level + 1);
        if (root.right != null) right = getHeight(root.right, level + 1);

        return Math.max(left, right);
    }
}
