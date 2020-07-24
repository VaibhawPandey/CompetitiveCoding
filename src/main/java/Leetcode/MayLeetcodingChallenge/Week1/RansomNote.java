package main.java.Leetcode.MayLeetcodingChallenge.Week1;

public class RansomNote {

    public static void main(String[] args) {

        System.out.println(new RansomNote().canConstruct("aa", "abb"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() == 0)
            return true;

        if (magazine.length() == 0)
            return false;

        int magazineCharAscii[] = new int[26];
        for (int i = 0; i < magazine.length(); i++)
            magazineCharAscii[magazine.charAt(i) - 'a']++;

        for (int i = 0; i < ransomNote.length(); i++) {

            if (magazineCharAscii[ransomNote.charAt(i) - 'a'] > 0)
                magazineCharAscii[ransomNote.charAt(i) - 'a']--;
            else
                return false;
        }

        return true;
    }
}
