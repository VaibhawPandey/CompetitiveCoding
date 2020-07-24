package main.java.Leetcode.JuneLeetcodingChallenge.Week2;

import java.util.*;

public class RandomizedSet {

    public static void main(String[] args) {

        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        System.out.println(randomizedSet.remove(0));
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        System.out.println(randomizedSet.getRandom());
    }

    List<Integer> itemList;
    Map<Integer, Integer> map;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {

        itemList = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if (map.get(val) != null)
            return false;

        itemList.add(val);
        int pos = itemList.size() - 1;
        map.put(val, pos);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if (map.get(val) == null)
            return false;

        int pos = map.get(val);
        map.remove(val);

        int last= itemList.size() - 1;
        if (pos != last) {

            int lastItem = itemList.get(last);
            Collections.swap(itemList, pos, last);
            itemList.remove(last);
            map.remove(lastItem);
            map.put(lastItem, pos);

        } else
            map.remove(pos);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {

        int size = itemList.size();
        if (size == 0)
            return -1;

        int pos = random.nextInt(size);
        return itemList.get(pos);
    }
}
