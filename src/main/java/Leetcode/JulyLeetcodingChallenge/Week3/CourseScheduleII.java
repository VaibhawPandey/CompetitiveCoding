package main.java.Leetcode.JulyLeetcodingChallenge.Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleII {

    class Graph {

        int V;
        ArrayList<ArrayList<Integer>> adj;

        Graph(int v) {
            this.V = v;
            adj = new ArrayList<>(v);
            for (int i = 0; i < v; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
        }

    }

    public static void main(String[] args) {
        // new CourseScheduleII().findOrder(2, new int[][]{{1,0}});

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Graph graph = new Graph(numCourses);
        for (int i = 0; i < prerequisites.length; i++)
            graph.addEdge(prerequisites[i][1], prerequisites[i][0]);

        boolean visited[] = new boolean[numCourses];


        return new int[]{1, 0};
    }
}
