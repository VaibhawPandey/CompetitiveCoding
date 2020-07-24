package main.java.MCBHackathon;

import java.util.*;

public class ShortestPath {

    public class Item {
        int row;
        int column;
        Item parent;

        Item (int row, int column, Item parent) {
            this.row = row;
            this.column = column;
            this.parent = parent;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        char grid[][] = new char[m][n];

        for (int i = 0; i < m; i++) {
            String s = scanner.next();
            for (int j = 0; j < n; j++)
                grid[i][j] = s.charAt(j);
        }

        Item root = null, dist = null;
        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                 if (grid[i][j] == '#')
                     visited[i][j] = true;
                 else
                     visited[i][j] = false;

                 if (grid[i][j] == 'X') {
                     root = new ShortestPath().new Item(i, j, null);
                 }

                 if (grid[i][j] == 'G'){
                     dist = new ShortestPath().new Item(i, j,null);
                 }
            }
        }

        if (root == null || dist == null)
            return;

        Queue<Item> queue = new ArrayDeque<>();
        queue.add(root);
        visited[root.row][root.column] = true;

        Item finalItem = null;

        int direction[][] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {

            Item item = queue.poll();
            // finalQueue.add(item);

            if (grid[item.row][item.column] == 'G') {
                finalItem = item;
                break;
            }

            for (int i = 0; i < direction.length; i++) {

                int p = item.row + direction[i][0], q = item.column + direction[i][1];

                if (isValid(p, q, m, n) && visited[p][q] == false) {
                    queue.add(new ShortestPath().new Item(p, q, item));
                    visited[p][q] = true;
                }
            }

        }

        while (finalItem != null) {
            grid[finalItem.row][finalItem.column] = 'P';
            finalItem = finalItem.parent;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] +" ");
            }
            System.out.println();
        }


    }

    private static boolean isValid(int p, int q, int m, int n) {

        if (p < 0 || p >= m || q < 0 || q >= n)
            return false;

        return true;
    }


}
