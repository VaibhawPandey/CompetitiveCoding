package main.java.HackerRank.Practice.DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxSubArraySum {

    public static void main(String[] args) {

        int A[] = {1,-2,3,-2};
        System.out.println(new MaxSubArraySum().maxSubarraySumCircular(A));
    }
    public int maxSubarraySumCircular(int[] A) {

        int n = A.length;
        if (n == 0) return 0;

        int sum = A[0];
        int min_so_far = A[0];
        int max_so_far = A[0];
        int maxTotal = A[0];
        int minTotal = A[0];

        // Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n; i++) {

            int num = A[i];
            max_so_far = Math.max(num, max_so_far + num);
            maxTotal = Math.max(maxTotal, max_so_far);

            min_so_far = Math.min(num, min_so_far + num);
            minTotal = Math.min(minTotal, min_so_far);

            sum += num;
        }

        if (sum == min_so_far) return maxTotal;
        return Math.max(sum - minTotal, maxTotal);
    }
}
