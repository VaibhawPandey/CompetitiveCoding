package main.java.Leetcode.WeeklyContest.WeeklyContest185;

public class ReformatString {

    public static void main(String[] args) {

        String s = "a0b1c2";
        System.out.println(new ReformatString().reformat(s));
    }
    public String reformat(String s) {

        String letters = "", digits = "", result = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digits += s.charAt(i);
            } else {
                letters += s.charAt(i);
            }
        }

        if (Math.abs(digits.length() - letters.length()) > 1)
            return "";

        if (digits.length() == letters.length()) {
            for (int i = 0; i < digits.length(); i++)
                result += String.valueOf(letters.charAt(i)) + String.valueOf(digits.charAt(i));
        }
        else
        if (digits.length() > letters.length()) {
            result += digits.charAt(0);
            for (int i = 1; i < digits.length(); i++)
                result += String.valueOf(letters.charAt(i-1)) +String.valueOf(digits.charAt(i));
        } else {
            result += letters.charAt(0);
            for (int i = 1; i < letters.length(); i++)
                result += String.valueOf(digits.charAt(i-1)) +String.valueOf(letters.charAt(i));
        }

        return result;

    }
}
