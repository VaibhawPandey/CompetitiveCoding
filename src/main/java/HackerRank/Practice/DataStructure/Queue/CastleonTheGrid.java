package main.java.HackerRank.Practice.DataStructure.Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class CastleonTheGrid {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);
        int startY = Integer.parseInt(startXStartY[1]);
        int goalX = Integer.parseInt(startXStartY[2]);
        int goalY = Integer.parseInt(startXStartY[3]);
        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        System.out.println(result);
    }

    static class Path {
        int x, y;
        Path parent;

        Path(int x, int y, Path parent) {

            this.x = x;
            this.y = y;
            this.parent = parent;

        }

    }

    static Queue<Path> queue = new ArrayDeque<>();
    static boolean visited[][];

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

        int n = grid.length;
        char gridL[][] = new char[n][n];

        for (int i = 0; i < n; i++)
            gridL[i] = grid[i].toCharArray();

        queue.add(new Path(startX, startY, null));
        visited = new boolean[n][n];

        while (!queue.isEmpty()) {

            Path path = queue.peek();
            if (path.x == goalX && path.y == goalY)
                break;

            queue.poll();

            if (!visited[path.x][path.y]) {

                visited[path.x][path.y] = true;

                for (int i = path.y + 1; i < gridL.length; i++) {
                    if (gridL[path.x][i] == 'X')
                        break;

                    queue.add(new Path(path.x, i, path));
                }

                for (int i = path.y - 1; i>= 0; i--) {
                    if (gridL[path.x][i] == 'X')
                        break;

                    queue.add(new Path(path.x, i, path));
                }

                for (int i = path.x + 1; i < gridL.length; i++) {
                    if (gridL[i][path.y] == 'X')
                        break;

                    queue.add(new Path(i, path.y, path));
                }

                for (int i = path.x - 1; i >= 0; i--) {
                    if (gridL[i][path.y] == 'X')
                        break;

                    queue.add(new Path(i, path.y, path));
                }

            }
        }

        int res = 0;

        Path path = queue.peek();
        while (path.parent != null) {
            res++;
            path = path.parent;
        }

        return res;
    }

}
