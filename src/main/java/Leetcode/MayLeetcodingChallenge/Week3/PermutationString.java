package main.java.Leetcode.MayLeetcodingChallenge.Week3;

public class PermutationString {

    public static void main(String[] args) {

        System.out.println(new PermutationString().checkInclusion("ab", "eidboaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() == 0)
            return true;

        if (s2.length() == 0 || s1.length() > s2.length())
            return false;

        int sa1[] = new int[26];
        int sa2[] = new int[26];

        int sLength1 = s1.length(), sLength2 = s2.length();

        for (int i = 0; i < sLength1; i++)
            sa1[s1.charAt(i) - 'a']++;

        for (int i = 0; i < sLength2; i++) {

            sa2[s2.charAt(i) - 'a']++;
            if (i < sLength1-1)
                continue;

            if (i >= sLength1)
                sa2[s2.charAt(i-sLength1) - 'a']--;

            boolean isPresent = true;
            for (int j = 0; j < 26; j++) {
                if (sa1[j] != sa2[j])
                    isPresent = false;
            }

            if (isPresent)
                return true;
        }

        return false;
    }
}
