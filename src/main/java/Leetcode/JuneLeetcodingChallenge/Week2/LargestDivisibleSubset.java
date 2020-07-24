package main.java.Leetcode.JuneLeetcodingChallenge.Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    public static void main(String[] args) {

        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1,2,3}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer> output = new ArrayList<>();
        int n = nums.length;

        if (n == 0)
            return output;

        Arrays.sort(nums);

        int count[] = new int[n];
        Arrays.fill(count, 1);

        int parent[] = new int[n];
        Arrays.fill(parent, -1);

        int mid_ind = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && count[i] < count[j] + 1) {
                    parent[i] = j;
                    count[i] = count[j] + 1;
                }
            }

            if (count[i] > count[mid_ind])
                mid_ind = i;
        }

        while (mid_ind != -1){

            output.add(nums[mid_ind]);
            mid_ind = parent[mid_ind];
        }

        Collections.reverse(output);
        return output;
    }
}
