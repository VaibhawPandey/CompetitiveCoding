package main.java.Leetcode.JuneLeetcodingChallenge.Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction {

    public static void main(String[] args) {

        new QueueReconstruction().reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
    }

    public int[][] reconstructQueue(int[][] people) {

        List<int[]> res = new ArrayList<>();

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] == o2[0]) return o1[1] > o2[1] ? 1: -1;
                else
                return o1[0] > o2[0] ? -1 : 1;

            }
        });

        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }

        return res.toArray(new int[people.length][2]);
    }
}
