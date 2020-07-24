package main.java.HackerRank.Practice.DataStructure;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

        String grid[] = {"...",".X.",".X."};
        System.out.println(minimumMoves(grid, 2, 0, 0, 2));
    }

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY)    {

        int n = grid.length;
        Grid pGA[][] = new Grid[n][n];
        boolean visited[][] = new boolean[n][n];

        pGA[startX][startY] = null;
        visited[startX][startY] = true;

        Queue<Grid> queue = new LinkedList<>();
        queue.offer(new Grid(startX, startY));

        while(!queue.isEmpty()) {

            Grid temp = queue.poll();
            int x = temp.row, y = temp.column;
            boolean isReachedFinalNode = false;

            // Row Check
            for (int i = y; i<n; i++) {
                if (grid[x].charAt(i) == 'X')
                    break;
                if (!visited[x][i]) {
                    visited[x][i] = true;
                    queue.offer(new Grid(x, i));
                    pGA[x][i] = new Grid(x, y);

                    if (x == goalX && i == goalY)
                        isReachedFinalNode = true;
                }
            }

            // Column Check
            int i = x+1, j = x-1;
            while (i <n && j>= 0) {
                if (grid[i].charAt(y) == 'X')
                    break;
                if (!visited[i][y]) {
                    visited[i][y] = true;
                    queue.offer(new Grid(i, y));
                    pGA[i][y] = new Grid(x, y);

                    if (i == goalX && y == goalY)
                        isReachedFinalNode = true;
                }
            }

            if (isReachedFinalNode)
                 break;
        }

        int minMoves = 0;

        Grid temp = pGA[goalX][goalY];
        while (true || temp != null) {
            minMoves++;
            if (temp.row == startX && temp.column == startY)
                break;
            goalX = temp.row; goalY = temp.column;
            temp = pGA[goalX][goalY];
        }

        return minMoves;
    }

    static class Grid {
        int row;
        int column;

        Grid(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
