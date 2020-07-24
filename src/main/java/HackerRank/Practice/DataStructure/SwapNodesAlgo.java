package main.java.HackerRank.Practice.DataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwapNodesAlgo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int indexes[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++)
                indexes[i][j] = scanner.nextInt();
        }

        int queryCount = scanner.nextInt();
        int queries[] = new int[queryCount];
        for (int i = 0; i < queryCount; i++)
            queries[i] = scanner.nextInt();

        int swapNodes[][] = swapNodes(indexes, queries);
        for (int i = 0; i < swapNodes.length; i++) {
            for (int j = 0; j < swapNodes[i].length; j++)
                System.out.println(swapNodes[i][j]);
        }

    }

    static class Node
    {
        int data, level;
        Node left, right;

        Node(int data, int level) {
            this.data = data;
            this.level = level;
            this.left = this.right = null;
        }
    };

    static int[][] swapNodes(int[][] indexes, int[] queries) {

        int numberOfQueries = queries.length;
        int numberOfIndexes = indexes.length;

        int result[][] = new int[numberOfQueries][numberOfIndexes];
        Node root = new Node(1, 1);
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(root);

        int n = 0;
        while (n < numberOfIndexes) {

            Node curr = nodes.poll();
            int leftNodeData = indexes[n][0];
            int rightNodeData = indexes[n][1];

            curr.left = leftNodeData == -1 ? null: new Node(leftNodeData, curr.level + 1);
            curr.right = rightNodeData == -1 ? null: new Node(rightNodeData, curr.level + 1);

            if (curr.left != null)
                nodes.offer(curr.left);

            if (curr.right != null)
                nodes.offer(curr.right);

            n++;
        }

        for (int i = 0; i < queries.length; i++) {

            
        }



        return result;
    }
}
