package main.java.Leetcode.JuneLeetcodingChallenge.Week2;

import java.util.*;

public class CheapestFlight {

    public static void main(String[] args) {

    }

    class Path{

         int dest;
         int cost;

         Path(int dest, int cost) {
             this.dest = dest;
             this.cost = cost;
         }
    }

    class City implements Comparable<City> {

        int src;
        int costFromSrc;
        int k;

        City (int src, int costFromSrc, int k) {
            this.src = src;
            this.costFromSrc = costFromSrc;
            this.k = k;
        }


        @Override
        public int compareTo(City o) {
            return this.costFromSrc > o.costFromSrc ? -1: 1;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        List<Path> adj[] = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int flight[]: flights)
            adj[flight[0]].add(new Path(flight[1], flight[2]));

        Queue<City> queue = new PriorityQueue<>(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.costFromSrc > o2.costFromSrc ? -1: 1;
            }
        });
        queue.add(new City(src, 0, K+1));

        while (!queue.isEmpty()) {

            City city = queue.poll();
            if (city.src == dst) return city.costFromSrc;

            if (city.k > 0) {
                for (Path path: adj[city.src])
                    queue.add(new City(path.dest, city.costFromSrc + path.cost, city.k - 1));
            }
        }

        return -1;
    }
}
