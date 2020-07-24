package main.java.Leetcode.JuneLeetcodingChallenge.Week1;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().change(5, new int[]{1, 2, 5}));
    }


//    public int change(int amount, int[] coins) {
//
//        int count[] = new int[amount+1];
//        count[0] = 1;
//
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (i >= coins[j]) {
//                    count[i] += count[i - coins[j]];
//                } else
//                    break;
//            }
//        }
//
//        return count[amount];
//    }

    public int change(int amount, int[] coins) {
        return countWays(amount, coins, coins.length);
    }


    private int countWays(int amount, int[] coins, int size) {

        int dp[][] = new int[amount +1][size + 1];
        for (int i = 0; i <= size; i++)
            dp[0][i] = 1;

        for (int i = 1; i <= amount; i++)
              dp[i][0] = 0;


        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= size; j++) {

                int val = coins[j-1];

                int contains = 0;
                if (i - val >= 0)
                    contains = dp[i - val][j];

                int non_contains = dp[i][j-1];

                dp[i][j] = contains + non_contains;
            }
        }


        return dp[amount][size];
    }


//    private int countWays(int amount, int[] coins, int size) {
//
//        if (amount == 0)
//            return 1;
//
//        if (size == 0 || amount < 0)
//            return 0;
//
//        int val = coins[size-1];
//
//        int contains = countWays(amount - val, coins, size);
//        int non_contains = countWays(amount, coins, size-1);
//
//        return contains + non_contains;
//    }
}
