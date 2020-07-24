package main.java.Leetcode.JulyLeetcodingChallenge.Week1;

import java.math.BigDecimal;

public class ArrangeCoins {

    public static void main(String[] args) {
        System.out.println(new ArrangeCoins().arrangeCoins(5));
    }

    public int arrangeCoins(int n) {

        return (int) ((Math.sqrt(8L * n + 1) - 1)/2);
    }
}
