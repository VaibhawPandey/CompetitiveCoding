package main.java.Leetcode.Chal30days.Week2;

import java.util.Stack;

public class BackSpaceStringCompare {

    public static void main(String[] args) {
        String s = "a##b",t = "d##c";
        System.out.println(backspaceCompare(s,t));
    }
    public static boolean backspaceCompare(String S, String T) {

        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        for (int i = 0; i < S.length(); i++) {
             if (S.charAt(i) == '#') {
                 if (!stack1.empty())
                     stack1.pop();
             }
             else
                 stack1.push(S.charAt(i));
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!stack2.empty())
                    stack2.pop();
            }
            else
                stack2.push(T.charAt(i));
        }

        if (stack1.size() != stack2.size())
            return false;

        while (!stack1.empty()) {
            if (stack1.pop() != stack2.pop())
                return false;
        }

        return true;

    }
}
