package main.java.Leetcode.WeeklyContest.WC193;

import main.java.Leetcode.Chal30days.Week5.BinaryTreeMaxPath;

import java.util.Arrays;

public class TreeAncestor {

    public static void main(String[] args) {

        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(getKthAncestor(3, 1));
    }

    static int p[];
    static int count[];
    public TreeAncestor(int n, int[] parent) {

        p = parent;
        count = new int[n];

        for (int i = 1; i < n; i++) {

            int cnt = i;
            while (parent[cnt] != -1) {
                if (count[parent[cnt]] != 0) {
                    count[cnt] = count[parent[cnt]] + 1;
                    break;
                } else {
                    count[cnt]++;
                    cnt = parent[cnt];
                }
            }
        }
    }

    public static int getKthAncestor(int node, int k) {

        if (k > count[node])
            return -1;

        while (k-- > 0)
            node = p[node];


        return node;
    }
}
