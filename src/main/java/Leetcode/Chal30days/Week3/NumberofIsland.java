package main.java.Leetcode.Chal30days.Week3;

import java.util.Scanner;

public class NumberofIsland {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        char grid[][] = new char[m][n];

        for (int i = 0; i < m; i++) {
            String row = scanner.next();
            for (int j = 0; j < n; j++)
                grid[i][j] = row.charAt(j);
        }

        System.out.println(new NumberofIsland().numIslands(grid));
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, m, n, grid);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int m, int n, char[][] grid) {
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(i - 1, j, m, n, grid);
            dfs(i + 1, j, m, n, grid);
            dfs(i, j - 1, m, n, grid);
            dfs(i, j + 1, m, n, grid);
        }
    }
}
