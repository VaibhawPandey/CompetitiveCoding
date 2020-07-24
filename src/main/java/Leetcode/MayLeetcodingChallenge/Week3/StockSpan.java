package main.java.Leetcode.MayLeetcodingChallenge.Week3;

import java.util.Stack;

public class StockSpan {

    // Stack<int[]> stack;
    int top, priceStock[], countStock[];


    StockSpan() {

        // stack = new Stack<>();
        priceStock = new int[10000];
        countStock = new int[10000];
        top = -1;
    }
//    public int next(int price) {
//
//        int res = 1;
//
//        while (!stack.isEmpty() && stack.peek()[0] < price)
//            res += stack.pop()[1];
//
//        stack.push(new int[]{price, res});
//        return res;
//    }

    //Alternative
    public int next(int price) {

        int res = 1;

        while (top >= 0 && priceStock[top] <= price)
            res += countStock[top--];

        top++;
        priceStock[top] = price;
        countStock[top] = res;

        return res;
    }
    public static void main(String[] args) {

        StockSpan stockSpan = new StockSpan();
        System.out.println(stockSpan.next(100));
    }
}
