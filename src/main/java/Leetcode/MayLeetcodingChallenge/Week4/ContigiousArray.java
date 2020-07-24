package main.java.Leetcode.MayLeetcodingChallenge.Week4;

import java.util.HashMap;

public class ContigiousArray {

    public static void main(String[] args) {
        System.out.println(new ContigiousArray().findMaxLength(new int[]{1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1}));
    }

    public int findMaxLength(int[] nums) {

         int res = 0, sum = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {

            sum += nums[i];
            if (!map.containsKey(sum))
                map.put(sum, i);
            else
                res = Math.max(res, i - map.get(sum));

        }

        return res;
    }
}
