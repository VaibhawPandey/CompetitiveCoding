package main.java.Leetcode.WeeklyContest.WeeklyContest192;

import java.util.Arrays;

public class PaintHouse {

    public static void main(String[] args) {

        System.out.println(new PaintHouse().minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}}, 5, 2, 3));
    }

    int dp[][][];
    private int getRes(int i, int j, int t, int[] houses, int[][] cost, int m, int n, int target) {

        if (t > target) return Integer.MAX_VALUE/2;
        if (i == m) {

            if (t == target) return 0;
            else return Integer.MAX_VALUE/2;
        }
        if (dp[i][j][t] != -1) return dp[i][j][t];
        else {
            int res = Integer.MAX_VALUE/2;

            if (houses[i] == 0) {
                for (int k = 0; k < n; k++)
                    res = Math.min(res, cost[i][k] + getRes(i+1, k+1, (j==k+1)? t: t+1, houses, cost, m, n, target));

            } else {
                res = Math.min(res, getRes(i+1, houses[i], (houses[i]==j)? t: t+1, houses, cost, m, n, target));
            }
            return dp[i][j][t] = res;
        }

    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new int[101][21][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 21; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int res = getRes(0, 0, 0, houses, cost, m, n, target);
        return res == Integer.MAX_VALUE/2 ? -1: res;
    }
}
