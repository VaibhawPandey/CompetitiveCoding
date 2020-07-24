package main.java.Leetcode.JulyLeetcodingChallenge.Week1;

public class UglyNumber {

    public static void main(String[] args) {

        System.out.println(new UglyNumber().nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {

        if (n == 0)
            return 0;

        int ugly[] = new int[n];
        ugly[0] = 1;
        int i1 = 0,i2 = 0,i3 = 0;

        int multiple_of_2 = ugly[i1] * 2;
        int multiple_of_3 = ugly[i2] * 3;
        int multiple_of_5 = ugly[i3] * 5;

        for (int i = 1; i < n; i++) {

            int next_ugly_no = Math.min(multiple_of_2, Math.min(multiple_of_3, multiple_of_5));
            ugly[i] = next_ugly_no;

            if (next_ugly_no == multiple_of_2) {
                multiple_of_2 = ugly[++i1] * 2;
            }
            if (next_ugly_no == multiple_of_3) {
                multiple_of_3 = ugly[++i2] * 3;
            }
            if (next_ugly_no == multiple_of_5) {
                multiple_of_5 = ugly[++i3] * 5;
            }
        }

        return ugly[n - 1];
     }
}
