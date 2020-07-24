package main.java.Leetcode.MayLeetcodingChallenge.Week1;

import java.util.*;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacter().firstUniqChar("leetcode"));
    }

    // Alternative
    private int firstUniqChar(String s) {

        if (s.length() == 0 || s.length() == 1)
            return s.length() - 1;

        int output = Integer.MAX_VALUE;
        for (char c='a'; c <= 'z'; c++) {

            int pos = s.indexOf(c);
            if (pos != -1 && pos == s.lastIndexOf(c)) {
                output = Math.min(pos, output);
            }
        }

        return output == Integer.MAX_VALUE ? -1: output;
    }




//    private int firstUniqChar(String s) {
//
//        if (s.length() == 0 || s.length() == 1)
//             return s.length() - 1;
//
//        int asciiCode[] = new int[26];
//
//        for (int i = 0; i < s.toCharArray().length; i++)
//             asciiCode[s.charAt(i) - 'a']++;
//
//        for (int i = 0; i < s.toCharArray().length; i++) {
//            if (asciiCode[s.charAt(i) - 'a'] == 1)
//                return i;
//        }
//
//        return -1;
//    }

}
