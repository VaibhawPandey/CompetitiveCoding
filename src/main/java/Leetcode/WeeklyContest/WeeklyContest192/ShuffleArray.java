package main.java.Leetcode.WeeklyContest.WeeklyContest192;

import java.util.Arrays;
import java.util.LinkedList;

public class ShuffleArray {
    public static void main(String[] args) {

    }

    public int[] shuffle(int[] nums, int n) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < nums.length; i++)
            linkedList.add(nums[i]);

        int left = 1, right = n;
        while (left < n) {

            int temp = linkedList.get(right);
            linkedList.remove(right);
            linkedList.add(left, temp);
            left += 2;
            right++;
        }

        Integer[] res = linkedList.toArray(new Integer[nums.length]);
        return Arrays.stream(res).mapToInt(Integer::intValue).toArray();
    }
}
