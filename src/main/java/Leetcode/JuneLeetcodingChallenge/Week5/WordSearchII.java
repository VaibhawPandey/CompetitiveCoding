package main.java.Leetcode.JuneLeetcodingChallenge.Week5;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public static void main(String[] args) {
        new WordSearchII().findWords(new char[][]{{}}, new String[]{"oath", "pea", "eat", "rain"});
    }

    class Trie {

        Trie children[];
        String word;

        Trie() {
            children = new Trie[26];

            for (int i = 0; i < 26; i++)
                children[i] = null;
            word = null;
        }

        public void insertWord(String word) {

            Trie currNode = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (currNode.children[index] == null)
                    currNode.children[index] = new Trie();

                currNode = currNode.children[index];
            }

            currNode.word = word;
        }
    }

    List<String> out = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        if (board.length < 1 || board[0].length < 1)
            return out;

        Trie root = new Trie();
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                root.insertWord(word);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                getOutput(i, j, board, root);
            }
        }

        return out;
    }

    private void getOutput(int x, int y, char[][] board, Trie root) {

        char c = board[x][y];

        if (c == '*' || root.children[c - 'a'] == null)
            return;

        root = root.children[c - 'a'];

        if (root.word != null) {
            out.add(root.word);
            root.word = null;
        }

        board[x][y] = '*';
        if (x + 1 < board.length) getOutput(x + 1, y, board, root);
        if (y + 1 < board[0].length) getOutput(x, y+1, board, root);
        if (x - 1 >= 0) getOutput(x - 1, y, board, root);
        if (y - 1 >= 0) getOutput(x, y - 1, board, root);
        board[x][y] = c;
    }
}
