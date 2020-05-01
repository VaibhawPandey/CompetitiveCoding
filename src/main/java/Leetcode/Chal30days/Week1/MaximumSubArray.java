package main.java.Leetcode.Chal30days.Week1;

public class MaximumSubArray {

    public static void main(String[] args) {

        int nums[] = {-1};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {

        int res = Integer.MIN_VALUE, tempMaxSum = 0;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > tempMaxSum && tempMaxSum < 0)
                tempMaxSum = nums[i];
            else tempMaxSum += nums[i];

            res = Math.max(tempMaxSum,res);
        }

        return res;

    }
}
