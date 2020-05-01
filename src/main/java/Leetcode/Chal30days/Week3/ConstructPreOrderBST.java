package main.java.Leetcode.Chal30days.Week3;

import com.sun.source.tree.Tree;

public class ConstructPreOrderBST {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public static void main(String[] args) {

        int preorder[] = {4,2};
        TreeNode root = new ConstructPreOrderBST().bstFromPreorder(preorder);
        System.out.println(root);
    }
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {

        if (preorder.length == 0)
            return null;
        int size = preorder.length;
        return constructTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    private TreeNode constructTree(int[] preorder, int minValue, int maxValue, int size) {

        if (index >= size)
            return null;

        TreeNode root = null;
        int key = preorder[index];

         if (key  > minValue && key < maxValue) {

             root = new TreeNode(key);
             index += 1;

             if (index < size) {
                 root.left = constructTree(preorder, minValue, key, size);
                 root.right = constructTree(preorder, key, maxValue, size);
             }
         }

         return root;
    }
}
