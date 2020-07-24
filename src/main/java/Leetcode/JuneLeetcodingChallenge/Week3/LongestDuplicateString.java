package main.java.Leetcode.JuneLeetcodingChallenge.Week3;

import java.util.HashMap;
import java.util.Scanner;

public class LongestDuplicateString {

    int prime = 10000001;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new LongestDuplicateString().longestDupSubstring(scanner.next()));
    }

    public String longestDupSubstring(String S) {

        int n = S.length();

        if (n == 0)
            return "";

        int d[] = new int[n];
        d[0] = 1;

        for (int i = 1; i < n; i++)
            d[i] = (d[i-1] * 26) % prime;

        int left = 0, right = n-1;
        String res = "";

        while (left < right) {

            int mid = (left + right)/2;
            String curr = getCurr(S, mid, d);
        }

        return res;
    }

    private String getCurr(String s, int len, int[] d) {

        int currSum = 1;
        for (int i = 0; i < len; i++)
           currSum = (currSum + d[len - i - 1] * (s.charAt(i) - 'a' + 1)) % prime;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(currSum, 1);

        String res = "";

        for (int i = len; i < s.length(); i++) {

            // currSum = (currSum - d[])
        }

        return res;
    }
}
