package main.java.Leetcode.WeeklyContest.WC194;

import java.util.HashMap;

public class FileName {

    public String[] getFolderNames(String[] names) {

        String out[] = new String[names.length];
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < names.length; i++) {

            if (hashMap.containsKey(names[i])) {
                int k = hashMap.get(names[i]) + 1;
                String temp = names[i] + "(" +k +")";
                while (hashMap.containsKey(temp)) {
                    k++;
                    temp = names[i] + "(" +k +")";
                }
                out[i] = temp;
                hashMap.put(names[i], k);
                hashMap.put(temp, 0);
            } else {
                hashMap.put(names[i], 0);
                out[i] = names[i];
            }
        }

        return out;
    }
}
