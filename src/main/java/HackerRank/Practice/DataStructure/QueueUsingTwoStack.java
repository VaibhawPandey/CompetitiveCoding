package main.java.HackerRank.Practice.DataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < n; i++) {

            int qType = scanner.nextInt();

            if (qType == 1) {

                int item = scanner.nextInt();
                stack1.push(item);

            } else if (qType == 2) {

                if (stack2.isEmpty()) {
                    System.out.println("S1Size:-" +stack1.size());
                    while (!stack1.isEmpty())
                        stack2.push(stack1.pop());
                }

                if (!stack2.isEmpty())
                    stack2.pop();


            } else {

                if (stack2.isEmpty()) {
                      while (!stack1.isEmpty())
                        stack2.push(stack1.pop());
                }
                if (!stack2.isEmpty())
                System.out.println(stack2.peek());
            }
        }

    }
}
