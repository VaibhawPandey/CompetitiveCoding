package main.java.Leetcode.JulyLeetcodingChallenge.Week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PrisonCell {

    public static void main(String[] args) {

        int out[] = new PrisonCell().prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000);
    }

    public int[] prisonAfterNDays(int[] cells, int N) {

        Map<String, Integer> map = new HashMap<>();
        Map<String, String> valueMap = new LinkedHashMap<>();

        String initialVal = new String();
        for (int i = 0; i < cells.length; i++) {
            initialVal += cells[i];
        }
        int loopCount = -1;

        for (int i = 0; i < N; i++) {

            String nextValue = getNextValue(initialVal);

            if (map.containsKey(nextValue)) {
                loopCount = i - map.get(nextValue);
                break;
            }
            else {
                map.put(nextValue, i);
                valueMap.put(initialVal, nextValue);
            }

            initialVal = nextValue;
        }

        String output = initialVal;

        if (loopCount != -1) {
            int remainingElement = N % loopCount;
            String keys[] = valueMap.keySet().toArray(new String[0]);
            output = keys[remainingElement];
        }

        for (int i = 0; i < cells.length; i++) {
              cells[i] = Character.getNumericValue(output.charAt(i));
        }

        return cells;
    }

    private String getNextValue(String intialVal) {

        StringBuilder temp = new StringBuilder("0");
        for (int i = 1; i < intialVal.length()-1; i++) {
            if ((intialVal.charAt(i-1) == '0' && intialVal.charAt(i+1) == '0') ||
                    (intialVal.charAt(i-1) == '1' && intialVal.charAt(i+1) == '1'))
                temp.append("1");
            else
                temp.append("0");
        }

        temp.append("0");

        return temp.toString();
    }
}
