package main.java.Leetcode.Chal30days.Week3;

import java.util.ArrayList;
import java.util.List;

public class LeftColumnAtLeastOne {

    interface BinaryMatrix {

      public int get(int row, int col);
      public List<Integer> dimensions();

    }

    public static void main(String[] args) {

        int matrix[][] = {{0,0},{1,1}};
        System.out.println(leftMostColumnWithOne(new BinaryMatrix() {
            @Override
            public int get(int row, int col) {
                return matrix[row][col];
            }

            @Override
            public List<Integer> dimensions() {
                List<Integer> dimensions =  new ArrayList<>();
                dimensions.add(matrix.length);
                dimensions.add(matrix[0].length);
                return dimensions;
            }
        }));
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {


        List<Integer> dimensions = binaryMatrix.dimensions();
        int i = 0, j = dimensions.get(1) - 1, minOutput = -1;

        while (i < dimensions.get(0) && j >= 0) {
            if (binaryMatrix.get(i, j) == 0)
                i++;
             else {
                minOutput = j;
                j--;
            }
        }

        return minOutput;
    }

}
