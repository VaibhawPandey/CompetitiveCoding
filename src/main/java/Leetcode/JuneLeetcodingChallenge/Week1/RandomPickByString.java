package main.java.Leetcode.JuneLeetcodingChallenge.Week1;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPickByString {

    public static void main(String[] args) {
        RandomPickByString obj = new RandomPickByString(new int[]{1, 3});
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
    }
    int prefixSum[];
    private Random rand;

    public RandomPickByString(int[] w) {
        // arr = w;
        int n = w.length;
        this.rand = new Random();

        this.prefixSum = new int[n];
        for (int i = 1; i < n; i++)
             w[i] += w[i-1];

        this.prefixSum = w;
    }

    public int pickIndex() {
        int n = this.prefixSum.length;
        int sum = this.prefixSum[n-1];

        if (sum == 0)
            return -1;

        int rem = this.rand.nextInt(sum) + 1;
        int left = 0, right = this.prefixSum.length - 1;

        while (left < right) {

            int mid = left + (right - left)/2;

            if (this.prefixSum[mid] == rem)
                return mid;
            else
            if (rem > this.prefixSum[mid])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}
