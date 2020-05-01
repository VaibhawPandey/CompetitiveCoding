package main.java.Leetcode.Chal30days.Week3;

public class MinPathSum {

    public static void main(String[] args) {
        int grid[][] = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new MinPathSum().minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
         int m = grid.length;
         if (m == 0)
             return 0;
         int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0)
                    grid[i][j] += grid[i][j-1];
                else if (i > 0 && j == 0)
                    grid[i][j] += grid[i-1][j];
                else if(i != 0 && j != 0)
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[m-1][n-1];
    }


}
