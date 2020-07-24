package main.java.Leetcode.MayLeetcodingChallenge.Week3;

import java.util.Scanner;

/*
  *
  * Count Square Submatrices with All Ones
  *
 */
public class SquareSubmatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int matrix[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println(new SquareSubmatrix().countSquares(matrix));
    }

    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        if (m == 0)
            return 0;

        int n = matrix[0].length;
        int dp[][] = new int[m+1][n+1];
        int result = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (matrix[i-1][j-1] == 1)
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));

                result += dp[i][j];
            }
        }

        return result;
    }
}
