package main.java.Leetcode.Chal30days.Week1;

public class MoveZeroes {
    public static void main(String[] args) {
       int nums[] = {0,1,0,3,12};
       moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {

        int n = nums.length, i=0;
        int resNums[] = new int[n];
        for (int j = 0; j < n; j++) {
            if(nums[j] != 0){
                resNums[i] = nums[j];
                i++;
            }
        }

        for (int j = 0; j < n; j++)
            System.out.print(resNums[j] +" ");

    }
}
