package main.java.Leetcode.WeeklyContest182;

public class LuckyNumber {

    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }
    public static int findLucky(int[] arr) {

        int temp[] = new int[501];
        int n = arr.length, max = Integer.MIN_VALUE,output = -1;

        for (int i = 0; i < n; i++)
            temp[arr[i]]++;

        for (int i = 0; i < n; i++) {
            if(temp[arr[i]] == arr[i])
                output = Math.max(output, arr[i]);
        }

        return output;
    }
}
