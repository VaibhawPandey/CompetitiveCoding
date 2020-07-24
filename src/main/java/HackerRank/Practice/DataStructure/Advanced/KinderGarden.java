package main.java.HackerRank.Practice.DataStructure.Advanced;

import java.util.Scanner;

public class KinderGarden {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        System.out.println(solve(arr));
    }

    static int solve(int[] t) {
        /*
         * Return the ID
         */

        int n = t.length, i = 0, res = Integer.MAX_VALUE;
        while (i < n) {
            int j = i;
            // if (t[j] == 0) {
                int count = 0, sum = 0;
                do {
                    if (t[i] - count <= 0)
                        sum++;

                    count++;
                    j++;
                    if(j == n)
                        j = 0;
                } while (j != i);
                res = Math.min(res, i + 1);
            // }
            i++;
        }

        return res;

    }
}
