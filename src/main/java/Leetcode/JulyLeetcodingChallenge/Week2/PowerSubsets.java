package main.java.Leetcode.JulyLeetcodingChallenge.Week2;

import java.util.ArrayList;
import java.util.List;

public class PowerSubsets {

    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        long powerSetCount = (long) Math.pow(2, size);
        List<List<Integer>> out = new ArrayList<>();

        for (int i = 0; i < powerSetCount; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) > 0)
                   temp.add(nums[j]);
            }
            out.add(temp);
        }

        return out;
    }
}
