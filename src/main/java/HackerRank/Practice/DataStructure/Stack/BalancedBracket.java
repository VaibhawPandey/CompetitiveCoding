package main.java.HackerRank.Practice.DataStructure.Stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            if (i == 582)
                System.out.println("String :-" +str[i]);
            System.out.println(isBalanced(str[i]));
        }

    }

    static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0;i< s.length(); i++){
            char temp = s.charAt(i);
            if (temp == ')' || temp == '}' || temp == ']') {


                if (stack.isEmpty() || (temp == ')' && stack.pop() != '(') || (temp == '}' && stack.pop() != '{') || (temp == ']' && stack.pop() != '[')) {
                    return "NO";
                }
            } else
                stack.push(temp);
        }

        if (stack.isEmpty())
        return "YES";
        else
            return "NO";
    }
}
