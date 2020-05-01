package main.java.Leetcode.Chal30days.Week1;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {

        int arr[] = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }
    public static int singleNumber(int[] nums) {

        int n = nums.length;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(hashMap.containsKey(nums[i]))
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            else
                hashMap.put(nums[i],1);
        }
        for (Map.Entry<Integer,Integer> map: hashMap.entrySet()){
            if(map.getValue() == 1){
                return map.getKey();
            }
        }
        return -1;
    }
}
