package main.java.HackerRank.Practice.DataStructure.Stack;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        String st = "";
        Stack<String> stk = new Stack<>();

        while (q >= 0) {

            int qId = scanner.nextInt();

            switch (qId) {
                case 1:
                   String str = scanner.next();
                   stk.push(st);
                   st += str;
                   break;
                case 2:
                    int val = scanner.nextInt();
                    stk.push(st);
                    st = st.substring(0, st.length() - val);
                    break;
                case 3:
                    val = scanner.nextInt();
                    // if (st.length() > val)
                    System.out.println(st.charAt(val - 1));
                    break;
                case 4:
                    st = stk.pop();
            }

            q--;
        }


    }


}
