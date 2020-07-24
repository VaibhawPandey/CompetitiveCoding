package main.java.Leetcode.WeeklyContest.WC194;

import java.util.*;

public class AvoidFlood {
    public static void main(String[] args) {

        System.out.println(new AvoidFlood().avoidFlood(new int[]{1,0,2,0}));
    }

    public int[] avoidFlood(int[] rains) {

        List<Integer> out = new ArrayList<>();
        int n = rains.length, containsZero = 0;
        List<Integer> zeroList = new ArrayList<>();
        Map<Integer, Integer> indexList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int temp = rains[i];
            if (temp > 0) {

                if (indexList.containsKey(temp)) {

                    int index = -1;
                    for (int j = 0; j < zeroList.size(); j++) {

                        if (zeroList.get(j) > indexList.get(temp)) {
                            index = j;
                            break;
                        }
                    }
                    if (containsZero == 0 || index == -1)
                        return new int[0];

                    containsZero--;
                    indexList.remove(temp);
                    out.add(zeroList.get(index), temp);
                    zeroList.remove(index);

                } else
                    indexList.put(temp, i);

                out.add(-1);
            } else {
                zeroList.add(i);
                containsZero++;
            }
        }

        Iterator<Integer> keySet = indexList.keySet().iterator();
        for (int i = 0; i < zeroList.size(); i++) {
            int next = keySet.hasNext() ? keySet.next(): -1;
            if (next != -1 && indexList.get(next) > zeroList.get(i))
                out.add(zeroList.get(i), keySet.next());
            else
                out.add(zeroList.get(i), 1);
        }

        return out.stream().mapToInt(i -> i).toArray();
    }
}
