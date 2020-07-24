package main.java.HackerRank.Practice.DataStructure.Queue;

import java.util.Scanner;

public class DownToZero {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(downToZero(n));
    }

    static int downToZero(int n) {
        /*
         * Write your code here.
         */

        int map[] = new int[n + 1];
        for (int i = 0; i <= n; i++)
            map[i] = i;

        int sqrt = (int) Math.sqrt(n);

        for (int i = 1; i < n; i++) {

            int score = map[i] + 1;

            if (i * i == n) {
                map[n] = score;
                break;
            }

            map[i+1] = Math.min(map[i+1], score);
            int limit;

            if (i > sqrt)
                limit = n;
            else
                limit = i*i;
            for (int j = i+i; j <= limit; j = j+i) {
                map[j] = Math.min(map[j], score);
            }
        }

        return map[n];
    }
}
