package main.java.Leetcode.WeeklyContest.WeeklyContest192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KStrongestValue {

    public static void main(String[] args) {
        new KStrongestValue().getStrongest(new int[]{-7, 22, 17, 3}, 2);
    }

    public int[] getStrongest(int[] arr, int k) {

        Arrays.sort(arr);
        int median = arr[(arr.length - 1)/2];

        int medianArray[][] = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++)
            medianArray[i] = new int[] {Math.abs(arr[i] - median), i};

        Arrays.sort(medianArray, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] > o2[1] ? -1: 1;
                else return o1[0] > o2[0] ? -1: 1;
            }
        });

        int res[] = new int[k];
        for (int i = 0; i < k; i++)
             res[i] = arr[medianArray[i][1]];

        return res;
    }
}
