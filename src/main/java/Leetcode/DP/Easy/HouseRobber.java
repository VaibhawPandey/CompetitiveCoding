package main.java.Leetcode.DP.Easy;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1}));
    }
    public int rob(int[] nums) {

        int n = nums.length;
        int dp[] = new int[n + 1];
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (i < 2)
                dp[i+1] = nums[i];
            else {
                dp[i+1] = nums[i] + Math.max(dp[i-1],dp[i-2]);
            }

            res = Math.max(res, dp[i+1]);
        }

        return res;
    }
}
