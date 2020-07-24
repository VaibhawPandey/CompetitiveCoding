package main.java.Leetcode.MayLeetcodingChallenge.Week1;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {

        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    // Alternate
    private int majorityElement(int[] nums) {

        int majorityElement = nums[0], mE_count = 1;
        int threshold = (int) Math.floor(nums.length/2);

        for (int i = 1; i < nums.length; i++) {
            if (majorityElement == nums[i]) mE_count++;
            else {
                mE_count--;
                if (mE_count == 0) {
                    majorityElement = nums[i];
                    mE_count = 1;
                }
            }
            if (mE_count > threshold) return majorityElement;
        }

        return majorityElement;
    }


//    public int majorityElement(int[] nums) {
//
//        if (nums.length == 1)
//            return nums[0];
//
//        Map<Integer, Integer> elementCount = new HashMap<>();
//        int n = nums.length;
//        int threshold = (int) Math.floor(n/2);
//
//        for (int i = 0; i < n; i++) {
//
//            if (elementCount.containsKey(nums[i])) {
//                int tempCount = elementCount.get(nums[i]) + 1;
//                if (tempCount > threshold)
//                    return nums[i];
//                elementCount.put(nums[i], tempCount);
//            } else
//                elementCount.put(nums[i], 1);
//        }
//
//        return -1;
//    }
}
