package main.java.Leetcode.Chal30days.Week1;

/*
  * Write an algorithm to determine if a number is "happy".
  * A happy number is a number defined by the following process: Starting with any positive integer, replace the
  * number by the sum of the squares of its digits, and repeat the process until the number equals 1
  * (where it will stay), or it loops endlessly in a cycle which does not include 1.
  * Those numbers for which this process ends in 1 are happy numbers.
  *
  * Input: 19
    Output: true
    Explanation:
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
    public static void main(String[] args) {

        int n = 19;
        System.out.println(isHappy(n));
    }
    public static boolean isHappy(int n) {

        if (n==1 || n==7)
            return true;
        if(n<10)
            return false;
        return isHappy(squareRootSum(n));
    }

    private static int squareRootSum(int n) {
        int sum = 0;

        while (n!=0){
            int digit = n % 10;
            sum += digit * digit;
            n = n/10;
        }

        return sum;
    }
}
