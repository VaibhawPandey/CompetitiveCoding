package main.java.Leetcode.MayLeetcodingChallenge.Week2;

public class CheckInaStraightLine {

    public static void main(String[] args) {

        int coordinates[][] = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(new CheckInaStraightLine().checkStraightLine(coordinates));
    }
    public boolean checkStraightLine(int[][] coordinates) {

         if (coordinates.length <= 2)
             return true;
         float gSlope = getSlope(coordinates[1], coordinates[0]);

        for (int i = 2; i < coordinates.length; i++) {
             float slope = getSlope(coordinates[i], coordinates[0]);

             if (slope != gSlope)
                 return false;
        }

        return true;
    }

    private float getSlope(int[] coordinate1, int[] coordinate2) {

        if ((coordinate1[0] - coordinate2[0]) == 0) return 0;

        float slope = (float) (coordinate1[1] - coordinate2[1])/(coordinate1[0] - coordinate2[0]);
        return slope;
    }


}
