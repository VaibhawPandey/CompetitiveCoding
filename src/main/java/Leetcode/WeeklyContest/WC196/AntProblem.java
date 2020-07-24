package main.java.Leetcode.WeeklyContest.WC196;

import java.util.Arrays;

public class AntProblem {

    public static void main(String[] args) {

    }

    public int getLastMoment(int n, int[] left, int[] right) {

        int maxLeft = left.length > 0 ? Arrays.stream(left).max().getAsInt() : 0;
        int maxRight = right.length > 0 ? Arrays.stream(right).max().getAsInt(): 0;

        return Math.max(maxLeft, maxRight);

    }
}
