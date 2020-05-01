package main.java.Leetcode.Chal30days.Week2;

public class PerformStringShift {

    public static void main(String[] args) {

        String s = "mecsk";
        int shift[][] = {{1,4},{0,5},{0,4},{1,1},{1,5}};

        System.out.println(stringShift(s,shift));
    }
    public static String stringShift(String s, int[][] shift) {

        int numberofShifts = 0;
        int n = s.length();
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0)
                numberofShifts -= shift[i][1];
            else
                numberofShifts += shift[i][1];
        }

        numberofShifts = Math.abs(numberofShifts % shift.length);


        if (numberofShifts < 0) {
            s = s.substring(-numberofShifts, n) +s.substring(0,-numberofShifts);
        } else  if (numberofShifts > 0) {
            s = s.substring(n-numberofShifts,n) +s.substring(0,n-numberofShifts+1);
        }

        return s;
    }
}
