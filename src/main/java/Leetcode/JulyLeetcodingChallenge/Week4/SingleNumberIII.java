package main.java.Leetcode.JulyLeetcodingChallenge.Week4;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        int res[] = {0, 0};
        int numsXOR = 0;

        for (int i = 0; i < nums.length; i++) {
            numsXOR ^= nums[i];
        }

        numsXOR &= -numsXOR;
        for (int i = 0; i < nums.length; i++) {
            if ((numsXOR & nums[i]) == 0)
                res[0] ^= nums[i];
            else
                res[1] ^= nums[i];
        }

        return res;
    }
}
