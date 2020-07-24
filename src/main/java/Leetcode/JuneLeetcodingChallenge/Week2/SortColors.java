package main.java.Leetcode.JuneLeetcodingChallenge.Week2;

public class SortColors {

    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public void sortColors(int[] nums) {

        for (int i = 0, left = 0, right = nums.length - 1; i <= right; i++) {

            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                i--; right--;
            }
        }

        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);

    }
}
