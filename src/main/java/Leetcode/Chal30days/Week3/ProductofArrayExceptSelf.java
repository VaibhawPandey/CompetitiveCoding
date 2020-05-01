package main.java.Leetcode.Chal30days.Week3;

public class ProductofArrayExceptSelf {

    public static void main(String[] args) {

        int nums[] = {1,2,3,4};
        int arr[] = productExceptSelf(nums);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] +" ");

    }

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return new int[]{0};

        int result[] = new int[n];
        int temp = 1;

        for (int i = 0; i < n; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;

        for (int i = n-1; i>=0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }

        return result;
    }
}
