package com.ag.tries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PrefixSearch {

    static class Trie{
        TrieNode root = new TrieNode();

        public void build(String[] words, int[] weights) {

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                //System.out.printf("%s ",word);
                TrieNode curr = root;
                char[] wd = new char[30];
                //print(root,wd, 0 );
                //System.out.println();
                for (int j = 0; j < word.length(); j++) {
                    char ch = word.charAt(j);
                    int idx = (int) ch - 'a';
                    if (curr.children[idx] == null) {
                        curr.children[idx] = new TrieNode();
                    }
                    curr = curr.children[idx];
                }
                curr.isEndOfWord = true;
                curr.weights.add(weights[i]);
            }
        }

        private void search(TrieNode curr,  char[] word, int level,List<Pair<String, Integer>> results) {
            if (curr.isEndOfWord) {
                for (int weight : curr.weights) {
                    //System.out.printf("%d", weight);
                    for (int k = level; k < word.length; k++){
                        word[k] = 0;
                    }
                    StringBuilder str = new StringBuilder();
                    for (char c : word) {
                        if(c != 0) {
                            str.append(c);
                        }
                    }
                    Pair<String, Integer> pair = new Pair<>(str.toString(), weight);
                    results.add(pair);
                }

            }

            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    word[level]= (char) (i + 'a');
                    search(curr.children[i], word, level+1,results);
                }
            }
        }

        public List<Pair<String, Integer>> search( String prefix) {
            TrieNode curr = root;
            int i = 0;
            char[] word = new char[30];
            List<Pair<String, Integer>> answer = new ArrayList<>();
            for (; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (curr.children[index] != null) {
                    word[i] = prefix.charAt(i);
                    curr = curr.children[index];
                } else {
                    answer.add(new Pair<>("-1", -1));
                    return answer;
                }
            }
            //System.out.printf("w:%s, i:%d%n", Arrays.toString(word), i);
            search(curr, word, i,answer );

            return  answer;
        }

        public void print(){

            print(this.root, new char[30], 0);
        }

        private void print(TrieNode curr, char[] str, int level) {
            if (curr.isEndOfWord) {

                for (int k = level; k < str.length; k++){
                    str[k] = 0;
                }

                for (char c : str) {
                    if (c != 0) {
                        System.out.printf("%c", c);
                    }
                }
                System.out.println();
            }

            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    str[level] = (char) (i + 'a');
                    print(curr.children[i], str, level + 1);
                }
            }

        }

    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        List<Integer> weights;

        TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }

            this.isEndOfWord = false;
            this.weights = new ArrayList<>();
        }
    }


    static class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            String[] words = new String[N];
            int[] weights = new int[N];
            String[] prefixes = new String[M];
            for (int j = 0; j < N; j++) {
                words[j] = sc.next();
            }
            for (int j = 0; j < N; j++) {
                weights[j] = sc.nextInt();
            }
            for (int j = 0; j < M; j++) {
                prefixes[j] = sc.next();
            }

            Trie dictionary = new Trie();
            dictionary.build(words, weights);
            char[] str = new char[30];
            //dictionary.print();
            Comparator<Pair<String, Integer>> pairComp = (o1, o2) -> o2.value - o1.value;
            List<Pair<String, Integer>> pairs = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                pairs.addAll(dictionary.search( prefixes[j]));
                pairs.sort(pairComp);
                int count = 1;
                for (Pair<String, Integer> pair: pairs ) {
                    if(count <=5){
                        System.out.printf("%s ", pair.key);
                    }
                    count++;
                }
                System.out.println();
                pairs.clear();
            }
        }
    }


}