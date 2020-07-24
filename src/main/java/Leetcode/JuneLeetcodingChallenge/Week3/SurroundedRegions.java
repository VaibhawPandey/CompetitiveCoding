package main.java.Leetcode.JuneLeetcodingChallenge.Week3;

public class SurroundedRegions {

    public void solve(char[][] board) {

        int m = board.length;
        if (m == 0)
            return;

        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O')
                    board[i][j] = '-';
        }

        for (int i = 0; i < m; i++)  // Left Side
            if (board[i][0] == '-')
                board = floodFill (board, i, 0, '-', 'O', m, n);

        for (int i = 0; i < m; i++) { // Right Side
            if (board[i][n-1] == '-')
                board = floodFill(board, i, n-1, '-', 'O', m, n);
        }

        for (int i = 0; i < n; i++) // Upper row
            if (board[0][i] == '-')
                board = floodFill (board, 0, i, '-', 'O', m, n);

        for (int i = 0; i < n; i++) // Lower row
            if (board[m-1][i] == '-')
                board = floodFill (board, m-1, i, '-', 'O', m, n);


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (board[i][j] == '-')
                    board[i][j] = 'X';
        }
    }

    private char[][] floodFill(char[][] board, int i, int j, char prevC, char fillC, int m, int n) {

        if (i < 0 || i > m || j < 0 || j > n || board[i][j] != prevC)
            return board;

        board[i][j] = fillC;

        floodFill(board, i+1, j, prevC, fillC, m, n);
        floodFill(board, i-1, j, prevC, fillC, m, n);
        floodFill(board, i, j+1, prevC, fillC, m, n);
        floodFill(board, i, j-1, prevC, fillC, m, n);

        return board;
    }
}
