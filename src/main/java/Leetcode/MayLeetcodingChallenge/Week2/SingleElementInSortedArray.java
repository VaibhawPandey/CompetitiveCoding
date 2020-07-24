package main.java.Leetcode.MayLeetcodingChallenge.Week2;

public class SingleElementInSortedArray {

    public static void main(String[] args) {

        int nums[] = {1, 2, 2, 3, 3};
        System.out.println(new SingleElementInSortedArray().singleNonDuplicate(nums));

    }
    public int singleNonDuplicate(int[] nums) {

        int left = 0, right = nums.length-1;
        while (left < right) {

            int mid = (left + right) / 2;

            if ((mid % 2 == 0 && nums[mid+1] == nums[mid]) || (mid % 2 != 0 && nums[mid-1] == nums[mid]))
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left];
    }
}
