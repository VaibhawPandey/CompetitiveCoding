package main.java.Leetcode.JuneLeetcodingChallenge.Week2;

import java.util.Scanner;

public class IsSubsequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(new IsSubsequence().isSubsequence(scanner.next(), scanner.next()));
    }

    public boolean isSubsequence(String s, String t) {

        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }

        if (i == s.length())
            return true;

        return false;
    }
}
