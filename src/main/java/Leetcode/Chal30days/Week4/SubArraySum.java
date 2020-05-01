package main.java.Leetcode.Chal30days.Week4;

import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {

        int nums[] = {1,1,1};
        int k = 2;
        System.out.println(new SubArraySum().subarraySum(nums, k));
    }
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> prevSum = new HashMap<>();
        int currSum = 0, result = 0;

        for (int i = 0; i < nums.length; i++) {

            currSum += nums[i];

            if (currSum == k)
                result++;

            if (prevSum.containsKey(currSum-k))
                result += prevSum.get(currSum-k);

            Integer count = prevSum.get(currSum);
            if (count == null)
                 prevSum.put(currSum, 1);
            else
                prevSum.put(currSum, count + 1);
        }

        return result;
    }


}
