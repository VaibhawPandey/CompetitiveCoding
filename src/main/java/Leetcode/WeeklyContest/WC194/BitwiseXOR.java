package main.java.Leetcode.WeeklyContest.WC194;

public class BitwiseXOR {

    public int xorOperation(int n, int start) {

        int res = start;
        for (int i = 1; i< n; i++) {
            int num = start + 2 * i;
            res ^= num;
        }

        return res;
    }
}
