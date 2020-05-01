package main.java.Leetcode.Chal30days.Week4;

public class MaximalSquare {
    public static void main(String[] args) {

        char matrix[][] = { {'0'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {

        if (matrix.length == 0)
            return 0;

        int sum[][] = new int[matrix.length+1][matrix[0].length+1];
        int maxSquare = 0;

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                 if (Character.getNumericValue(matrix[i-1][j-1]) == 1) {
                     sum[i][j] = Math.min(Math.min(sum[i-1][j], sum[i][j-1]), sum[i-1][j-1]) + 1;
                     maxSquare = Math.max(maxSquare, sum[i][j]);
                 } else
                     sum[i][j] = 0;
            }
        }

        return maxSquare * maxSquare;
    }
}
