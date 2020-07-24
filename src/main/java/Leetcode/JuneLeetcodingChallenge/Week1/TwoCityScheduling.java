package main.java.Leetcode.JuneLeetcodingChallenge.Week1;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

    public static void main(String[] args) {


    }

    public int twoCitySchedCost(int[][] costs) {

        int n = costs.length;
        int a = n/2, b = n/2, ans = 0;

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0] - o1[1]) > Math.abs(o2[0] - o2[1]) ? 1 : -1;
            }
        });

        for (int i = 0; i < n; i++) {

            if (b == 0 || (costs[i][0] <= costs[i][1] && a > 0)) {
                a--;
                ans += costs[i][0];
            } else {
                b--;
                ans += costs[i][1];
            }

        }

        return ans;

    }
}
