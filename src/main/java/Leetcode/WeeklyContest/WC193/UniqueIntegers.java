package main.java.Leetcode.WeeklyContest.WC193;

import java.util.*;

public class UniqueIntegers {

    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }

        int countArr[] = new int[map.size()];
        int idx = 0;

        for (Map.Entry entry: map.entrySet()) {
            countArr[idx] = (int) entry.getValue();
            idx++;
        }

        Arrays.sort(countArr);
        idx = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] <= k) {
                k -= countArr[i];
                idx++;
            } else
                break;
        }

        return countArr.length - idx;
    }
}
