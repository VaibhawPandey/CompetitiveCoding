package main.java.Leetcode.JuneLeetcodingChallenge.Week4;

import main.java.Leetcode.MayLeetcodingChallenge.Week2.PerfectSquare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {

        int sqrt = (int) Math.sqrt(n);

        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= sqrt; i++)
            numList.add(i * i);

        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < numList.size(); j++) {

                if (numList.get(j) <= i) {

                    int res = dp[i - numList.get(j)];
                    if (res != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], 1 + res);
                } }
        }

        return dp[n];
    }
}
