package main.java.Leetcode.WeeklyContest.WC196;

public class NumberofSquareSubMatrix {

    public int numSubmat(int[][] mat) {

        int ans = 0;
        int m = mat.length;

        if (m == 0)
            return ans;

        int n = mat[0].length;
        int dp[][] = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

            }
        }

        return 0;
    }
}
