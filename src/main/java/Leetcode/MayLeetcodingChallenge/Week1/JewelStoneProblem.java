package main.java.Leetcode.MayLeetcodingChallenge.Week1;

public class JewelStoneProblem {

    public static void main(String[] args) {
        System.out.println(new JewelStoneProblem().numJewelsInStones("aA", "aAAbbbb"));
    }
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0)
            return 0;

        int asciiCount[] = new int[128];
        int count = 0;

        for (int i = 0; i < J.toCharArray().length; i++)
            asciiCount[J.charAt(i)]++;

        for (int i = 0; i < S.toCharArray().length; i++) {
            if (asciiCount[S.charAt(i)] > 0)
                count++;
        }

        return count;
    }
}
