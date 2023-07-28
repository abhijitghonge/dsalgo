package com.ag.tries;

public class Dictionary2 {
    // Trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;

        // Returns new trie node (initialized to NULLs)
        public TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            isLeaf = false;
        }
    }

    static class Trie {
        TrieNode root;

        // function to insert a node in Trie
        void insert(String key) {
            int level;
            int length = key.length();
            TrieNode pCrawl = root;

            for (level = 0; level < length; level++) {
                int index = key.charAt(level) - 'a';

                if (pCrawl.children[index] == null) {
                    pCrawl.children[index] = new TrieNode();
                }

                pCrawl = pCrawl.children[index];
            }

            pCrawl.isLeaf = true;
        }

        // function to check if current node is leaf node or not
        boolean isLeafNode(TrieNode root) {
            return root.isLeaf != false;
        }

        // function to display the content of Trie
        void display(TrieNode root, char[] str, int level) {
            // If node is leaf node, it indicates end
            // of string, so a null character is added
            // and string is displayed
            if (isLeafNode(root)) {
                for (int k = level; k < str.length; k++)
                    str[k] = 0;
                System.out.println(str);
            }

            int i;
            for (i = 0; i < 26; i++) {
                // if NON NULL child is found
                // add parent key to str and
                // call the display function recursively
                // for child node
                if (root.children[i] != null) {
                    str[level] = (char) (i + 'a');
                    display(root.children[i], str, level + 1);
                }
            }
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) {
// Keys to be inserted in Trie
        String[] keys = {"the", "a", "there", "answer",
                "any", "by", "bye", "their"};
        Trie trie = new Trie();
        trie.root = new TrieNode();

        // Inserting keys in Trie
        int n = keys.length;
        for (int j = 0; j < n; j++) {
            trie.insert(keys[j]);
        }

        int level = 0;
        char[] str = new char[20];

        // Displaying content of Trie
        System.out.println("Content of Trie: ");
        trie.display(trie.root, str, level);
    }
}
