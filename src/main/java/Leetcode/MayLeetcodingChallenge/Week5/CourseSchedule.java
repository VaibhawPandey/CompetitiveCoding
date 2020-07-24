package main.java.Leetcode.MayLeetcodingChallenge.Week5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer> adj[] = new ArrayList[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {

            int x = prerequisites[i][0], y = prerequisites[i][1];
            if (adj[x] == null)
                adj[x] = new ArrayList<>();

            adj[x].add(y);
        }

        boolean visited[] = new boolean[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            for (Integer ad: adj[i]) {
                if (ad == i)
                    return false;
            }
        }

        return true;
    }
}
