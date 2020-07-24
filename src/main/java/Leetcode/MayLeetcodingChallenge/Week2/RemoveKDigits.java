package main.java.Leetcode.MayLeetcodingChallenge.Week2;

import java.util.ArrayDeque;

public class RemoveKDigits {
    public static void main(String[] args) {

        String num = "5337";
        System.out.println(new RemoveKDigits().removeKdigits(num, 2));

    }
    public String removeKdigits(String num, int k) {

        if (num.length() <= k)
            return "0";

        int n = num.length();
        int i = 0, top = -1;
        char numChars[] = num.toCharArray();
        numChars[++top] = numChars[i++];

        for (int j = 0; j < k; j++) {
            while (true) {
                if (i == n || (top >= 0 && numChars[top] > numChars[i])) {
                    top--;
                    break;
                }
                numChars[++top] = numChars[i++];
            }
        }

        while (top+1 < n-k)
            numChars[++top] = numChars[i++];

        i = 0;
        while (i <= top && numChars[i] == '0')
            i++;

        return i > top ? "0": new String(numChars, i, top+1-i);
    }
}
