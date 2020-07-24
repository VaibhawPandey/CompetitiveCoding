package main.java.Leetcode.JuneLeetcodingChallenge.Week2;

import java.util.Scanner;

public class PowerofTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new PowerofTwo().isPowerOfTwo(scanner.nextInt()));
    }

    public boolean isPowerOfTwo(int n) {

        return n != 0 && ((n & (n-1)) == 0);
    }
}
