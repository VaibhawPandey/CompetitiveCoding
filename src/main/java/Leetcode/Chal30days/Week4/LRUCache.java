package main.java.Leetcode.Chal30days.Week4;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer,Integer> mLRUCache;
    int capacity;

    public LRUCache(int capacity) {
        mLRUCache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (mLRUCache.containsKey(key)) {
            int val = mLRUCache.get(key);
            mLRUCache.remove(key);
            mLRUCache.put(key, val);
            return val;
        } else
            return -1;
    }

    public void put(int key, int value) {

        if (mLRUCache.containsKey(key))
            mLRUCache.remove(key);

        if (mLRUCache.size() == capacity)
            mLRUCache.remove(mLRUCache.entrySet().iterator().next().getKey());

        mLRUCache.put(key, value);
    }
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
