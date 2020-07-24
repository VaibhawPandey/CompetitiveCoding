package main.java.HackerRank.Practice.DataStructure.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contacts {

    static class Trie {
        Trie children[];
        int count;

        Trie() {
            this.children = new Trie[26];
            this.count = 1;
            for (int i = 0; i < 26; i++)
                this.children[i] = null;
         }
    }
    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        List<Integer> res = new ArrayList<>();
        Trie root = new Trie();

        for (int i = 0; i < queries.length; i++) {

            if (queries[i][0].equals("add")) {

                char s[] = queries[i][1].toCharArray();
                Trie curr = root;

                for (int j = 0; j < s.length; j++) {
                    int index = s[j] - 'a';
                    if (curr.children[index] == null)
                        curr.children[index] = new Trie();
                    else
                        curr.children[index].count++;

                    curr = curr.children[index];
                }

            } else {

                char s[] = queries[i][1].toCharArray();
                Trie curr = root;
                boolean isAvailable = true;

                for (int j = 0; j < s.length; j++) {
                    int index = s[j] - 'a';
                    if (curr.children[index] == null) {
                        isAvailable = false;
                        break;
                    }
                    curr = curr.children[index];
                }

                if (isAvailable)
                    res.add(curr.count);
                else
                    res.add(0);
            }
        }

        Integer resList[] = res.toArray(new Integer[res.size()]);
        return Arrays.stream(resList).mapToInt(Integer::intValue).toArray();
    }
}
