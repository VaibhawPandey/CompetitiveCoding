package main.java.Leetcode.WeeklyContest.WC195;

public class MaxVowels {

    public static void main(String[] args) {
        System.out.println(new MaxVowels().maxVowels("weallloveyou", 7));
    }


    public int maxVowels(String s, int k) {

        int n = s.length(), maxVowelCount = 0, i = 1;

        if (k > n)
            return 0;

        int vowelCount = 0;

        for (int j = 0; j < k; j++) {
            if (isVowel(s.charAt(j)))
                vowelCount++;
        }
        maxVowelCount = vowelCount;

        while (i + k <= n) {

            if (isVowel(s.charAt(i - 1)))
                vowelCount--;

            if (isVowel(s.charAt(i + k - 1)))
                vowelCount++;

            maxVowelCount = Math.max(maxVowelCount, vowelCount);
            i++;
        }

        return maxVowelCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // Alternate
//    public int maxVowels(String s, int k) {
//
//        int n = s.length(), maxVowelCount = 0;
//        int i = 0;
//
//        if (k > n)
//            return 0;
//
//        while (i + k <= n) {
//            int vowelCount = 0;
//            int indexofFirstVowel = -1;
//
//            for (int j = i; j < i + k; j++) {
//                if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u'){
//                    vowelCount++;
//                    if (indexofFirstVowel == -1 && j != i)
//                        indexofFirstVowel = j;
//                }
//            }
//
//            maxVowelCount = Math.max(vowelCount, maxVowelCount);
//
//            if (indexofFirstVowel != -1 && indexofFirstVowel + k < n)
//                i = indexofFirstVowel;
//            else
//                i++;
//        }
//
//        return maxVowelCount;
//    }
}
