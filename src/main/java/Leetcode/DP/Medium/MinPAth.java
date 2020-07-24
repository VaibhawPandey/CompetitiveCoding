package main.java.Leetcode.DP.Medium;

public class MinPAth {

    public int mctFromLeafValues(int[] arr) {

        int n = arr.length;
        int maxElement[][] = new int[arr.length][arr.length];
        int dp[][] = new int[arr.length][arr.length];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i+1; j < n; j++) {
                max = Math.max(arr[j], max);
                maxElement[i][j] = max;
            }
        }

        for (int len = 1; len < n; len++) {
            for (int left = 0; left < n; left++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;

                if (len == 1) {
                    dp[left][right] = arr[left] * arr[right];
                } else {
                    for (int i = left; i < right; i++) {
                       // dp[left][right] =
                    }
                }

            }
        }

        return 0;
    }
}
