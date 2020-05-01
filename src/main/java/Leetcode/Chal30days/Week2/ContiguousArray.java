package main.java.Leetcode.Chal30days.Week2;

import java.util.HashMap;

public class ContiguousArray {

    public static void main(String[] args) {

        int nums[] = {0,1,1,0,1,0,0};
        System.out.println(findMaxLength(nums));
    }
    public static int findMaxLength(int[] nums) {

        int maxLen = 0,sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0)
                 sum += -1;
            else
                sum += 1;

            if (sum == 0)
                maxLen = i+1;


            if (map.containsKey(sum)) {
                if (maxLen < i - map.get(sum))
                    maxLen = i - map.get(sum);
            } else
                map.put(sum, i);

        }

        return maxLen;
    }
}
