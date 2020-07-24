package main.java.Leetcode.JulyLeetcodingChallenge.Week1;

import java.util.Scanner;

public class IslandPerimeter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt(), n = scanner.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {

        int ans = 0;
        int n = grid.length;

        if (n == 0)
            return ans;

        int m = grid[0].length;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) ans++;
                    if (i == n - 1 || grid[i + 1][j] == 0) ans++;
                    if (j == 0 || grid[i][j - 1] == 0) ans++;
                    if (j == m - 1 || grid[i][j + 1] == 0) ans++;
                }
            }
        }

        return ans;
    }


}
