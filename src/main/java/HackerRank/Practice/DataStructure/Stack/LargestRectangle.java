package main.java.HackerRank.Practice.DataStructure.Stack;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        System.out.println(largestRectangle(a));
    }

    static long largestRectangle(int[] h) {

        Stack<Integer> stack = new Stack<>();
        int n = h.length, i = 0;
        long res = 0;

        while (i < n) {

            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {

                int top = stack.pop();
                long temp_res = h[top] * (stack.isEmpty() ? i: i - stack.peek() - 1);
                res = Math.max(res, temp_res);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            long temp_res = h[top] * (stack.isEmpty() ? i: i - stack.peek() - 1);
            res = Math.max(res, temp_res);
        }

        return res;
    }
}
