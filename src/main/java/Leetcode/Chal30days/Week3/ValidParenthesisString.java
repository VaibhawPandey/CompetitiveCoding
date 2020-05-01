package main.java.Leetcode.Chal30days.Week3;

import java.util.Stack;

public class ValidParenthesisString {

    public static void main(String[] args) {

        String str = "*(((*)*";
        System.out.println(checkValidString(str));
    }
    public static boolean checkValidString(String s) {

        Stack<Integer> so = new Stack<>();
        Stack<Integer> sa = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                so.push(i);
            else if (s.charAt(i) == '*')
                sa.push(i);
            else {
                if (so.isEmpty() && sa.isEmpty())
                    return false;
                else if (!so.isEmpty())
                       so.pop();
                else
                    sa.pop();
            }
        }

        while (!so.isEmpty() && !sa.isEmpty()) {
            if (sa.peek() > so.peek()) {
                sa.pop(); so.pop();
            } else
                return false;
        }

        return so.isEmpty();
    }
}
