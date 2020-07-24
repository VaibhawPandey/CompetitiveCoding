package main.java.Leetcode.Chal30days.Week4;

import java.util.*;

public class FirstUnique {

    // List<Integer> list;
    HashMap<Integer, Boolean> mMap;

    public FirstUnique(int[] nums) {
        mMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            add(nums[i]);
    }

    public int showFirstUnique() {
        for (Map.Entry entry: mMap.entrySet()) {
            if ((Boolean) entry.getValue())
                return (Integer) entry.getKey();
        }
        return -1;
    }

    public void add(int value) {
         if (mMap.containsKey(value))
             mMap.put(value, false);
         else
             mMap.put(value, true);
    }

    public static void main(String[] args) {

        FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(5);
        firstUnique.add(3);
        firstUnique.add(3);
        firstUnique.add(2);
        firstUnique.add(3);
        firstUnique.add(17);
        System.out.println(firstUnique.showFirstUnique());
        
    }
}
