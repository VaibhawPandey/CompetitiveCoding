package main.java.Leetcode.WeeklyContest.WC197;

import java.util.*;

public class MaxProbabilityPath {

    public static void main(String[] args) {
        System.out.println(new MaxProbabilityPath().maxProbability(5, new int[][]{{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}}, new double[]{0.37,0.17,0.93,0.23,0.39,0.04}, 3, 4));
    }

    class State {
        int state;
        double prob;

        State(int state, double prob) {
            this.state = state;
            this.prob = prob;
        }
    }
    double res = 0.0;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        Map<Integer, List<State>> graph = new HashMap<>();
        double count = 1.0;

        for (int i = 0; i < edges.length; i++) {

            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());

            graph.get(edges[i][0]).add(new State(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new State(edges[i][0], succProb[i]));
        }



        // Math.pow()
        for (State state: graph.get(start))
        getMaxProbability(state, 1.0, end, graph);

//        for (State state: graph.get(start))
//            queue.add(new State(state.state, state.prob));
//
//        while (!queue.isEmpty()) {
//
//            State temp = queue.poll();
//            getMaxProbability(temp, 1.0, end, graph);
//
////            for (State state: graph.get(temp.state))
////                queue.add(new State(state.state, state.prob));
//        }
        

        return res;
    }

    private void getMaxProbability(State temp, double prob, int end, Map<Integer, List<State>> graph) {

        if (temp == null)
            return;

        if (temp.state == end) {
            res = Math.max(res, prob * temp.prob);
            return;
        }

        for (State state: graph.get(temp.state))
            getMaxProbability(state, prob * temp.prob, end, graph);
    }
}
