package main.java.Leetcode.Chal30days.Week4;

public class LongestSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestSubsequence().longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }
    public int longestCommonSubsequence(String text1, String text2) {

        if (text1.equals(text2))
            return text1.length();

        int tl1 = text1.length();
        int tl2 = text2.length();

        if (tl1 == 0 || tl2 == 0)
            return 0;

        int dp[][] = new int[tl1 + 1][tl2 + 1];

        for (int i = 1; i <= tl1; i++) {
            for (int j = 1; j <= tl2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[tl1][tl2];
    }
}
