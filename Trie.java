/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode[] list = root.children;
        for (int i = 0; i < word.length(); i++) {
            if (list[word.charAt(i) - 'a'] == null) {
                TrieNode node = new TrieNode();
                node.value = word.charAt(i);
                list[word.charAt(i) - 'a'] = node;
            }
            if (i == word.length() - 1) {
                list[word.charAt(i) - 'a'].isEnd = true;
            }
            list = list[word.charAt(i) - 'a'].children;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode[] list = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (list[c - 'a'] == null) {
                return false;
            } else {
                 if (i == word.length() - 1) {
                    return list[c - 'a'].isEnd;
                 } else {
                     list = list[c - 'a'].children;
                 }
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode[] list = root.children;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (list[c - 'a'] == null) {
                return false;
            } else {
                list = list[c - 'a'].children;
            }
        }
        
        return true;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; 
        Character value = 'a';
        boolean isEnd = false;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
