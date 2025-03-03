import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    // Searches for a word in the trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    // Searches for a prefix in the trie
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    // Trie Node definition
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words
        trie.insert("cat");
        trie.insert("car");
        trie.insert("care");
        trie.insert("dog");

        // Search for words
        System.out.println(trie.search("cat"));    // true
        System.out.println(trie.search("car"));    // true
        System.out.println(trie.search("can"));    // false

        // Prefix search
        System.out.println(trie.startsWith("ca")); // true
        System.out.println(trie.startsWith("do")); // true
        System.out.println(trie.startsWith("da")); // false
    }
}
