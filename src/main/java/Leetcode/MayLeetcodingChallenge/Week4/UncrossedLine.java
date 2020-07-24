package main.java.Leetcode.MayLeetcodingChallenge.Week4;

public class UncrossedLine {

    public static void main(String[] args) {
        System.out.println(new UncrossedLine().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }

    public int maxUncrossedLines(int[] A, int[] B) {

        int m = A.length, n = B.length;
        
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }

            }
        }
        
        return dp[m][n];
    }
}
