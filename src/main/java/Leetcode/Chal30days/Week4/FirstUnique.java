package main.java.Leetcode.Chal30days.Week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstUnique {

    List<Integer> list;
    HashMap<Integer, Boolean> map;

    public FirstUnique(int[] nums) {
        list = new ArrayList<>();
        // map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i]))
                list.add(nums[i]);
            else
                list.remove(nums[i]);
        }
    }

    public int showFirstUnique() {
        return list.get(0);
    }

    public void add(int value) {
        if (!list.contains(value))
            list.add(value);
        else
            list.remove(value);
    }

    public static void main(String[] args) {

        FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        
    }
}
