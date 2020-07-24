package main.java.Leetcode.MayLeetcodingChallenge.Week4;

import java.util.ArrayList;
import java.util.List;

public class IntervalList {
    public static void main(String[] args) {

    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        int m = A.length, n = B.length;
        List<int[]> list = new ArrayList<>();

        int i = 0, j = 0;

       while (i < m && j < n) {

                int x1 = A[i][0], y1 = A[i][1], x2 = B[j][0], y2 = B[j][1];
                int x = Math.max(x1, x2);
                int y = Math.min(y1, y2);

                if (x <= y) list.add(new int[]{x, y});

                if (y1 == y2) {
                    i++; j++;
                } else
                    if (y1 == y) i++;
                    else
                       j++;

       }

      return list.toArray(new int[list.size()][]);
    }
}
