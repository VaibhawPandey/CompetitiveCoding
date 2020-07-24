package main.java.Leetcode.JuneLeetcodingChallenge.Week3;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public static void main(String[] args) {

        System.out.println(new PermutationSequence().getPermutation(4, 2));
    }

    public String getPermutation(int n, int k) {

        StringBuilder res = new StringBuilder("");
        if (n == 0 || k == 0)
            return res.toString();

        int fact[] = new int[n+1];
        fact[1] = 1;
        for (int i = 2; i <= n; i++)
            fact[i] = fact[i - 1] * i;

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            arr.add(i);

        int blockSize;
        while (res.length() < n-1) {
            blockSize = fact[arr.size()]/arr.size();
            int pos = (k-1)/blockSize;
            res.append(arr.get(pos));
            arr.remove(pos);
            k = k % blockSize;
            if (k == 0) {
                for (int i = arr.size() - 1; i >= 0; i--)
                    res.append(arr.get(i));
            }
        }

        if (res.length() < n ) res.append(arr.get(0));

        return res.toString();
    }
}
