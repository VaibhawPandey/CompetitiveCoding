package main.java.Leetcode.MayLeetcodingChallenge.Week2;

public class PerfectSquare {
    public static void main(String[] args) {

        System.out.println(new PerfectSquare().isPerfectSquare(2147483647));
    }
    public boolean isPerfectSquare(int num) {

        long left = 1, right = num;

        while (left <= right) {
            long mid = (left + right)/2;
            long temp = mid * mid;
            if (temp == num)
                return true;

            if (temp > num)
                right = mid-1;
            else
                left = mid+1;
        }

        return false;
    }
}
