package main.java.Leetcode.JuneLeetcodingChallenge.Week3;

public class HIndex {

    public static void main(String[] args) {

        System.out.println(new HIndex().hIndex(new int[]{0, 3, 3, 5, 6}));
    }

    public int hIndex(int[] citations) {

        int left = 0, right = citations.length - 1;
        // int out = Integer.MIN_VALUE;
        while (left <= right) {

            int mid = (left + right)/2;

            if (citations[mid] < citations.length - mid)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return citations.length - left;
    }
}
