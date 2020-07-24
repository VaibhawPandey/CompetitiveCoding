package main.java.Leetcode.JuneLeetcodingChallenge.Week4;

public class UniqueBST {

    public int numTrees(int n) {

        int dp[] = new  int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                dp[i] += dp[i - j] * dp[j - 1];
        }

        return dp[n];
    }
}