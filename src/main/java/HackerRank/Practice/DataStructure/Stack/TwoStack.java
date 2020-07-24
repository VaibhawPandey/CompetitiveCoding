package main.java.HackerRank.Practice.DataStructure.Stack;

import java.util.Scanner;

public class TwoStack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int m = scanner.nextInt(), n = scanner.nextInt();
        int a[] = new int[m];
        int b[] = new int[n];
        int x = scanner.nextInt();

        for (int i = 0; i < m; i++)
            a[i] = scanner.nextInt();

        for (int i = 0; i < n; i++)
            b[i] = scanner.nextInt();

        System.out.println(twoStacks(x, a, b));
    }

    static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */

        int sum = 0, i = 0, j = 0, maxIndex = 0;
        int m = a.length, n = b.length;

        if (m == 0 && n == 0)
            return 0;

        while (i < m && a[i] <= x - sum) {
            sum += a[i];
            i++;
        }

        maxIndex = i;


        while (j < n && i >= 0) {
            sum += b[j];
            j++;
            while (sum > x && i > 0) {
                i--;
                sum -= a[i];
            }
            if (sum <= x && i+j > maxIndex)
                maxIndex = i + j;
        }

        return maxIndex;
    }


}
