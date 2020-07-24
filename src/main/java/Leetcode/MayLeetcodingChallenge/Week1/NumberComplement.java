package main.java.Leetcode.MayLeetcodingChallenge.Week1;

public class NumberComplement {
    public static void main(String[] args) {

        System.out.println(new NumberComplement().findComplement(5));
    }

    public int findComplement(int num) {

        if (num == 0)
            return 1;
         if(num == 1)
             return 0;

         char numArray[] = Integer.toBinaryString(num).toCharArray();

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = numArray[i] == '1' ? '0': '1';
        }

        return Integer.parseInt(new String(numArray), 2);
    }
}
