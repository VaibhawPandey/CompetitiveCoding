package main.java.Leetcode.Chal30days.Week1;

public class BuyAndSell {
    public static void main(String[] args) {
        int prices[] = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {

        int n = prices.length, res = 0;

        for (int i = 0; i < n-1; i++) {
            int temp = prices[i+1]-prices[i];
            if ( temp>0 )
                res += temp;
        }

        return res;
    }
}
