package main.java.Leetcode.JuneLeetcodingChallenge.Week4;

import java.util.*;

public class ReconstructIteniary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<List<String>> list = new ArrayList<>();
        String line[] = scanner.nextLine().split(" ");

        for (int i = 0; i < line.length; i = i + 2) {

            List<String> childList = new ArrayList<>();
            childList.add(line[i]);
            childList.add(line[i+1]);
            list.add(childList);
        }

        new ReconstructIteniary().findItinerary(list);

    }

    List<String> out = new ArrayList<>();
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket: tickets) {

            PriorityQueue<String> pq = new PriorityQueue<>();
            if (map.containsKey(ticket.get(0)))
                 pq = map.get(ticket.get(0));

            pq.offer(ticket.get(1));
            map.put(ticket.get(0), pq);
        }

        dfs("JFK");

        return out;
    }

    private void dfs(String key) {

        if (map.containsKey(key)) {
            while (!map.get(key).isEmpty())
                dfs(map.get(key).remove());
        }

        out.add(0, key);
    }
}
