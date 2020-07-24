package main.java.Leetcode.JulyLeetcodingChallenge.Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

    public static void main(String[] args) {

        new Sum3().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }



    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i+1, high = nums.length - 1, sum = 0 - nums[i];

                while (low < high) {

                    if (nums[low] + nums[high] == sum) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]); list.add(nums[low]); list.add(nums[high]);
                        out.add(list);
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++; high--;
                    } else if (nums[low] + nums[high] < sum)
                        low++;
                    else
                        high--;
                }

            }
        }

        return out;
    }


}
