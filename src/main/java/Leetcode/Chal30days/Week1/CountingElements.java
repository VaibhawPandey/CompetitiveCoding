package main.java.Leetcode.Chal30days.Week1;

public class CountingElements {
    public static void main(String[] args) {
      int arr[] = {1,1,2};
        System.out.println(countElements(arr));
    }
    public static int countElements(int[] arr) {

        int numberCount[] = new int[1001];
        int count = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            numberCount[arr[i]]++;
            max = Integer.max(arr[i],max);
        }

        for (int i = 1; i <= max; i++) {
            if (numberCount[i-1] != 0 && numberCount[i] != 0)
            count += Math.max(numberCount[i - 1], numberCount[i]);
        }

        return count;
    }
}
