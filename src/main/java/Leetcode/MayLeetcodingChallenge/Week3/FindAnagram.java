package main.java.Leetcode.MayLeetcodingChallenge.Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindAnagram {

    public static void main(String[] args) {

        List<Integer> out = new FindAnagram().findAnagrams("abab", "ab");
        for (Integer res: out)
            System.out.print(res +" ");
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();
        if (s == null || p == null)
            return output;

        int sl = s.length();
        int pl = p.length();

        if (pl > sl)
            return output;

        int pa[] = new int[26];
        int sa[] = new int[26];

        for (int i = 0; i < pl; i++)
            pa[p.charAt(i) - 'a']++;

        for (int i = 0; i < sl; i++) {
            int temp = s.charAt(i) - 'a';
            sa[temp]++;
            if (i < pl - 1)
                continue;
            if (i >= pl)
               sa[s.charAt(i-pl) - 'a']--;
            boolean isFound = true;
            for (int j = 0; j < 26; j++) {
                if (sa[j] != pa[j]) {
                    isFound = false;
                    break;
                }
            }

            if (isFound)
                output.add(i - pl + 1);
        }



        return output;


    }
}
