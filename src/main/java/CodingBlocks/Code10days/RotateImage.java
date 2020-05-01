package main.java.CodingBlocks.Code10days;

public class RotateImage {

    public static void main(String[] args) {

        int nums[] = {5,1,3};
        int target = 5;
        System.out.println(new RotateImage().search(nums, target));
    }
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid;
                else
                    left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid;
            }
        }

        return -1;
    }
}
