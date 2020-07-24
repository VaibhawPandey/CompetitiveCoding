package main.java.Leetcode.DP.Medium;

public class MaxBlockSum {

    public static void main(String[] args) {
        int out[][] = new MaxBlockSum().matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2);
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {

        int m = mat.length;
        if (m == 0)
            return new int[][]{{0}};
        int n = mat[0].length;

        int sum[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                sum[i][j] = mat[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int p = Math.min(i + K, m-1), q = Math.min(j + K, n-1), r = Math.max(i - K, 0), s = Math.max(j - K, 0);

                mat[i][j] = sum[p + 1][q + 1] - sum[p + 1][s] - sum[r][q + 1] + sum[r][s];
            }
        }

        return mat;
    }
}
