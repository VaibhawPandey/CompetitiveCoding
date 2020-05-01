package main.java.CodingBlocks.DailyCode;

import java.util.HashMap;
import java.util.Scanner;

public class April17 {

    static HashMap<Long,String> dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong(), l = scanner.nextLong(), r = scanner.nextLong();

        dp = new HashMap<Long, String>();
        String result = getResult(n);
        int count = 0;
        // System.out.println(result.substring(l,r));
    }

    private static String getResult(long n) {

        if (dp.containsKey(n))
            return dp.get(n);

        if (n == 1 || n == 0)
            return String.valueOf(n);

        dp.put(n, getResult((int) Math.floor(n/2)) +getResult(n%2) +getResult((int) Math.floor(n/2)));

        return dp.get(n);
    }
}
