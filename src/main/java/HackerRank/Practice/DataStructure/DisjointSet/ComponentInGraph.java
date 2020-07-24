package main.java.HackerRank.Practice.DataStructure.DisjointSet;

import java.util.Arrays;
import java.util.Scanner;

public class ComponentInGraph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int gb[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            gb[i][0] = scanner.nextInt();
            gb[i][1] = scanner.nextInt();
        }

        int out[] = componentsInGraph(gb);
        for (int i = 0; i < out.length; i++)
            System.out.println(out[i]);

    }

    static int[] componentsInGraph(int[][] gb) {

        int parent[] = new int[gb.length * 2];
        Arrays.fill(parent, -1);

        for (int i = 0; i < gb.length; i++) {

            int x = find(parent, gb[i][0]);
            int y = find(parent, gb[i][1]);

            parent[y] = x;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int ans[] = new int[parent.length];
        Arrays.fill(ans, 1);

        for (int i = 0; i < parent.length; i++) {

            if (parent[i] != -1) {
                int temp = parent[i];
                while (temp != -1 && temp != parent[temp]) {
                    ans[i] += ans[temp];
                    // ans[temp] = 0;
                    temp = parent[temp];
                }
            }

            max = Math.max(max, ans[i]);
            if (ans[i] != -1)
            min = Math.min(min, ans[i]);

        }

        return new int[]{min, max};
    }

    private static int find(int[] parent, int i) {
        if (parent[i] == -1 || parent[i] == i)
            return i;

        return find(parent, parent[i]);
    }
}
