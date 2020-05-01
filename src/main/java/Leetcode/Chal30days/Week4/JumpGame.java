package main.java.Leetcode.Chal30days.Week4;

public class JumpGame {

    public static void main(String[] args) {

        int nums[] = {3, 2, 1, 0, 4};
        System.out.println(new JumpGame().canJump(nums));
    }
    public boolean canJump(int[] nums) {

        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {

             if (maxIndex<i)
                 return false;

             maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return true;
    }
}
