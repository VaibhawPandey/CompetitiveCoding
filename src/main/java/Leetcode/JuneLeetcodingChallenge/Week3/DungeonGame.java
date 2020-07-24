package main.java.Leetcode.JuneLeetcodingChallenge.Week3;

import java.util.Arrays;

public class DungeonGame {

    public static void main(String[] args) {

        System.out.println(new DungeonGame().calculateMinimumHP(new int[][]{{0, -3}}));
    }

    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length, n = dungeon[0].length;

        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        dp[m][n-1] = 1;
        dp[m-1][n] = 1;

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {

                int minHp = Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j];

                if (minHp < 1)
                    dp[i][j] = 1;
                else dp[i][j] = minHp;
            }
        }

        return dp[0][0];
    }
}
