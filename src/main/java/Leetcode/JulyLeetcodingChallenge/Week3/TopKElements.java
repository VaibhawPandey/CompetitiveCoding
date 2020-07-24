package main.java.Leetcode.JulyLeetcodingChallenge.Week3;

import java.util.*;

public class TopKElements {

    public static void main(String[] args) {

    }

    // Alternative
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            maxCount = Math.max(maxCount, map.get(nums[i]));
        }

        List<Integer> bucket[] = new ArrayList[maxCount+1];

        for (Map.Entry entry: map.entrySet()) {

            if (bucket[(int) entry.getValue()] == null)
                bucket[(int) entry.getValue()] = new ArrayList<>();

            bucket[(int) entry.getValue()].add((int) entry.getValue());
        }

        int out[] = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && idx < k;i--) {
            if (bucket[i] != null) {
                for (Integer val: bucket[i]) {
                    out[idx] = val; idx++;
                } }
        }

        return out;
    }

//    public int[] topKFrequent(int[] nums, int k) {
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//        list.sort(Map.Entry.comparingByValue());
//
//        int out[] = new int[k];
//        int n = list.size() - 1;
//
//        for (int i = 0; i < k; i++)
//            out[i] = list.get(n - i).getKey();
//
//        return out;
//    }
}
