package main.java.Leetcode.WeeklyContest.WC193;

import java.util.Map;

public class MinNumberofDays {

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
    }

    public static int minDays(int[] bloomDay, int m, int k) {

        if (bloomDay.length == 0 || m == 0 || k == 0)
            return -1;

        if (bloomDay.length < m * k)
            return -1;

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }

        while (min <= max) {
            int mid = (min + max)/2;
            if (isValid(bloomDay, m, k, mid)) max = mid - 1;
            else min = mid + 1;
        }

        return min;
    }

    private static boolean isValid(int[] bloomDay, int m, int k, int mid) {

        int currSize = 0, currCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= mid) currSize++;
            else currSize = 0;

            if (currSize == k) {
                currSize = 0;
                currCount++;
                if (currCount == m) return true;
            }
        }

        return false;
    }
}
