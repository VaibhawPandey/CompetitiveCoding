package main.java.Leetcode.MayLeetcodingChallenge.Week2;

public class FloodFill {

    public static void main(String[] args) {

        int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
        image = new FloodFill().floodFill(image, 1, 1, 2);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int sp = image[sr][sc];
        if (image[sr][sc] != newColor)
             return colorAll(image, sr, sc, newColor, sp);
        else
            return image;
    }

    private int[][] colorAll(int[][] image, int sr, int sc, int newColor, int sp) {

        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
            return image;

        if (image[sr][sc] == sp) {

            image[sr][sc] = newColor;
            colorAll(image, sr + 1, sc, newColor, sp);
            colorAll(image, sr, sc + 1, newColor, sp);
            colorAll(image, sr - 1, sc, newColor, sp);
            colorAll(image, sr, sc - 1, newColor, sp);
        }

        return image;
    }
}
