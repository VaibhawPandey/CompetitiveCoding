package main.java.Leetcode.JulyLeetcodingChallenge.Week3;

import java.util.HashMap;
import java.util.Map;

public class WordSearch {

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{{'A', 'B'}},"BA"));
    }

    // boolean visited[][];
    public boolean exist(char[][] board, String word) {

        if (word.length() == 0)
            return true;

        int m = board.length;
        if (m == 0)
            return false;

        int n = board[0].length;

        boolean visited[][] = new boolean[m][n];
        // int direction[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checkBoard(i, j, m, n, word, 0, board, visited))
                    return true;
            }
        }


        return false;
    }

    private boolean checkBoard(int i, int j, int m, int n, String word, int idx, char[][] board, boolean[][] visited) {


        if (idx == word.length())
            return true;

        if (i >= m || i < 0 || j >= n || j < 0 || visited[i][j])
            return false;

        if (board[i][j] != word.charAt(idx))
            return false;

        idx++;
        visited[i][j] = true;
        boolean res = checkBoard(i+1, j, m, n, word, idx, board, visited) || checkBoard(i-1, j, m, n, word, idx, board, visited) || checkBoard(i, j+1, m, n, word, idx, board, visited) || checkBoard(i, j-1, m, n, word, idx, board, visited);
        visited[i][j] = false;

        return res;
    }
}
