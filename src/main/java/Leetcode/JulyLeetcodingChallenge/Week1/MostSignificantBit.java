package main.java.Leetcode.JulyLeetcodingChallenge.Week1;

public class MostSignificantBit {

    public static void main(String[] args) {
        new MostSignificantBit().plusOne(new int[]{9});
    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int newDigit[] = new int[digits.length+1];
        newDigit[0] = 1;

        return newDigit;
    }
}
