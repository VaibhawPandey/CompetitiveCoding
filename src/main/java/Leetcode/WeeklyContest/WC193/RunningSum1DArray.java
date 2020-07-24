package main.java.Leetcode.WeeklyContest.WC193;

public class RunningSum1DArray {

    public static void main(String[] args) {

    }

    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++)
             nums[i] += nums[i-1];

        return nums;
    }
}
