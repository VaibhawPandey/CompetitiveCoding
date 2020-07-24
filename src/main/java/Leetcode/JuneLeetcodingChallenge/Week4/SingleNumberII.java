package main.java.Leetcode.JuneLeetcodingChallenge.Week4;

public class SingleNumberII {

    public static void main(String[] args) {


    }

    public int singleNumber(int[] nums) {

        int ones = 0, twos = 0, thrice = 0;
        for (int num: nums) {

            twos = twos | (ones & num);
            ones = ones ^ num;
            thrice = twos & ones;
            ones &= ~thrice;
            twos &= ~thrice;
        }

        return ones;
    }


}
