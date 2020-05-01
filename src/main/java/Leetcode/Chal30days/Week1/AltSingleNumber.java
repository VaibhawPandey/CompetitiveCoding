package main.java.Leetcode.Chal30days.Week1;

public class AltSingleNumber {
    public static void main(String[] args) {
        int arr[] = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }
    public static int singleNumber(int[] nums) {
        int output = nums[0];
        for (int i = 1; i < nums.length; i++) {
            output = output^nums[i];
        }
        return output;
    }
}
