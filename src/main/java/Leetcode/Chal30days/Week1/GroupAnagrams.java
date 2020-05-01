package main.java.Leetcode.Chal30days.Week1;

import javax.swing.*;
import java.util.*;
import java.util.stream.IntStream;

public class GroupAnagrams {
    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output = groupAnagrams(strs);
        for (List<String> list: output){
            for (String s: list)
                System.out.print(s +" ");
            System.out.println();
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> output = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

//        for (String s: strs){
//            int charSum = 0;
//            for (int i = 0; i < s.length(); i++)
//                charSum += s.charAt(i);
//
//            List<String> arr = new ArrayList<>();
//            if (map.containsKey(charSum)) {
//                arr = map.get(charSum);
//                arr.add(s);
//                map.put(charSum, arr);
//            } else {
//                arr.add(s);
//                map.put(charSum, arr);
//            }
//        }

        for (int i = 0; i < strs.length; i++) {
            char charArray[] = strs[i].toCharArray();
            Arrays.sort(charArray);
            if (map.containsKey(String.valueOf(charArray)))
                map.get(String.valueOf(charArray)).add(strs[i]);
            else {
                List<String> arr = new ArrayList<>();
                arr.add(strs[i]);
                map.put(String.valueOf(charArray), arr);
            }
        }

        for (Map.Entry set: map.entrySet())
            output.add((List<String>) set.getValue());


        return output;
    }
}
