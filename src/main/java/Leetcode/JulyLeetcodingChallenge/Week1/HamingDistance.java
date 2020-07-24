package main.java.Leetcode.JulyLeetcodingChallenge.Week1;

public class HamingDistance {
    public int hammingDistance(int x, int y) {
        String temp = Integer.toBinaryString(x ^ y);

        int count =0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1')
                count++;
        }

        return count;
    }
}
