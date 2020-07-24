package main.java.HackerRank.Practice.DataStructure.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Waiter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), q = scanner.nextInt();
        int number[] = new int[n];

        for (int i = 0; i < n; i++)
            number[i] = scanner.nextInt();

        int res[] = waiter(number, q);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] +" ");
    }

    static int[] waiter(int[] number, int q) {
        /*
         * Write your code here.
         */

        int res[] = new int[number.length];
        int count =0;
        Stack<Integer> b[] = new Stack[q + 1];
        Stack<Integer> a = new Stack<>();

        for (int i = 0; i < number.length; i++)
            a.push(number[i]);

        int primeNumbers[] = getPrimeNumbers(q);

        for (int i = 1; i<= q; i++) {

            b[i] = new Stack<>();
            Stack<Integer> tempStack = a;
            a = new Stack<>();

            while (!tempStack.isEmpty()) {
                if (tempStack.peek() % primeNumbers[i] == 0)
                    b[i].push(tempStack.pop());
                else
                    a.push(tempStack.pop());
            }
        }


        for (int i = 1; i <= q; i++) {
             while (!b[i].isEmpty()) {
                 res[count] = b[i].pop();
                 count++;
             }
        }

        while (!a.isEmpty()) {
            res[count] = a.pop();
            count++;
        }


        return res;
    }

    private static int[] getPrimeNumbers(int q) {

        if (q <= 2)
            return new int[]{2, 3};

         int primeNumber[] = new int[q + 1];
         primeNumber[1] = 2;
         primeNumber[2] = 3;

         int count = 3, num = 4;

         while (count <= q) {

             boolean isPrime = true;
             for (int i = num/2; i>1;i--) {
                 if (num % i == 0) {
                     isPrime = false;
                     break;
                 }
             }

             if (isPrime) {
                 primeNumber[count] = num;
                 count++;
             }
             num++;
         }

         return primeNumber;
    }
}
