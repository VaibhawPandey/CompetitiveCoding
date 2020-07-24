package main.java.Leetcode.MayLeetcodingChallenge.Week4;

import java.util.*;

public class SortCharacterbyFrequency {

    public static void main(String[] args) {

        System.out.println(new SortCharacterbyFrequency().frequencySort("raaeaedere"));
    }
    public String frequencySort(String s) {

        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);


        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        while (!maxHeap.isEmpty()) {
            Character character = maxHeap.remove();
            for (int i = 0; i < map.get(character); i++) {
                res.append(character);
            }
        }


        return res.toString();
    }
}
