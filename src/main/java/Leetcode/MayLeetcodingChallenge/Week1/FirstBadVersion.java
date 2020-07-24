package main.java.Leetcode.MayLeetcodingChallenge.Week1;

import java.util.Arrays;

public class FirstBadVersion {

    static boolean badVersionArray[];
    public static void main(String[] args) {

        int n = 2126753390;
        new FirstBadVersion().setBadVersionArray(n);
        System.out.println(new FirstBadVersion().firstBadVersion(n));
    }

    private void setBadVersionArray(int n) {
        badVersionArray = new boolean[n];
        Arrays.fill(badVersionArray, 1702766719, n, true);
    }



    public int firstBadVersion(int n) {

        int left = 1, right = n;
        while (left < right) {

           int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int pos) {
        return badVersionArray[pos];
    }
}
