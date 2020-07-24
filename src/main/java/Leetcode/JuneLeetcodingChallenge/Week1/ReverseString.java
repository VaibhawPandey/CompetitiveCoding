package main.java.Leetcode.JuneLeetcodingChallenge.Week1;

public class ReverseString {
    public void reverseString(char[] s) {

        int a = 0, b = s.length - 1;

        while (a < b) {

            char temp = s[a];
            s[a] = s[b];
            s[b] = temp;
            a++; b--;
        }

        for (int i = 0; i < s.length; i++)
            System.out.println(s[i]);

    }
}
