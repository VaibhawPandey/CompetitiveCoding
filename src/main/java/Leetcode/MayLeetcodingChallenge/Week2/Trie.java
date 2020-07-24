package main.java.Leetcode.MayLeetcodingChallenge.Week2;

public class Trie {

    Trie children[];
    boolean isEndOfWord;

    public static void main(String[] args) {

        Trie root = new Trie();
        root.insert("apple");
        System.out.println(root.search("apple"));   // returns true
        System.out.println(root.search("app"));     // returns false
        System.out.println(root.startsWith("app")); // returns true
        root.insert("app");
        System.out.println(root.search("app"));

    }

    Trie() {
        children = new Trie[26];
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }

    // static Trie root;

    /** Inserts a word into the trie. */
    public void insert(String word) {

        Trie currTrie = getCurrentTrie(word);
        currTrie.isEndOfWord = true;
    }

    private Trie getCurrentTrie(String word) {

        int len = word.length();
        Trie currTrie = this;
        char wordChar[] = word.toCharArray();

        for (int i = 0; i < len; i++) {
            int index = wordChar[i] - 'a';

            if (currTrie.children[index] == null)
                currTrie.children[index] = new Trie();

            currTrie = currTrie.children[index];
        }

        return currTrie;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        Trie currTrie = searchTrie(word);
        return (currTrie != null && currTrie.isEndOfWord);
    }

    private Trie searchTrie(String word) {

        int len = word.length();
        Trie currTrie = this;
        char wordChar[] = word.toCharArray();

        for (int i = 0; i < len; i++) {
            int index = wordChar[i] - 'a';

            if (currTrie.children[index] == null)
               return null;

            currTrie = currTrie.children[index];
        }

        return currTrie;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        Trie currTrie = searchTrie(prefix);
        return currTrie!= null;
    }
}
