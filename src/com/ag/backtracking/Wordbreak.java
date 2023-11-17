package com.ag.backtracking;

import java.util.*;

public class Wordbreak {
    public static void main(String[] args) {
        String input = "abaabbaababaabababaababaababbbabbabbbaaaabbbbbabbbbbabaaabbbbbbabbbbaabaaaabbbaabbabaabbabababbbbabbbbabaabaabbababbbbabaaababaaabbbbabaabbabbbaabaaababababaaaaaabaaabaabbabbbbaaaaabbbbbbaabbbbaababbaaababbaabbabbabbaaaabababbbbbaabbbbbbabbaaabbaaababbbababbbabbbbaabbabaaaababbbbbabbaaababaabbbaabbabababbaababbaababbbbabbabbbbaabbbbbbababbbaaabbabbabbbbabbabbbbbbbbaabaaaabbbbabaabbbaababbbbbbaaabbaabaabbbaabaabaabbabbababbaababbbbbbbbaaabaabbababbbbabbabbaaabaaaababbababaaabbbbaabbbabbaabbbabbabaababaaaababbaabababababbabbbaaaaabababbaaaaab";

        String[] dictionary = {"abbbbaba", "aabb", "aaaa", "babbababaa", "b", "bba", "ba", "abaa", "babababa", "bbaaaa", "bab", "bb", "b", "b", "baaaba", "abaa", "aaaab", "aabbabbbb", "abba", "ab", "abab", "aaabbbabbb", "aaaba", "b", "ba", "bbaaa", "babaaa", "baaa", "b", "aaabaabba"};
        String input1 = "Myinterviewlimit";
        String[] dictionary1 = {"My", "interview", "limit"};

        Wordbreak puzzle = new Wordbreak();
        ArrayList<String> dict = new ArrayList<>(Arrays.asList(dictionary));
        long start = System.currentTimeMillis();
        System.out.printf("answer:%d%n", puzzle.wordBreak(input, dict));
        long end = System.currentTimeMillis();
        System.out.printf("time:[%d] ms", end - start);

    }

    Map<String, Boolean> seen = new HashMap<>();

    public int wordBreak(String A, ArrayList<String> B) {

        HashSet<String> dictionary = new HashSet<>(B);
        return wordBreakInternal(A, dictionary, A.length()) ? 1 : 0;
    }

    private boolean wordBreakInternal(String str, HashSet<String> dictionary, int N) {

        for (int i = 1; i <= N; i++) {
            String word = str.substring(0, i);

            //System.out.printf("w:%s,i:%d ",word, i );
            if (dictionary.contains(word)) {
                seen.put(word, true);

                if (i == N) return true;

                String next = str.substring(i);

                if (seen.containsKey(next) && seen.get(next)) {
                    return true;
                } else if (seen.containsKey(next) && !seen.get(next)) {
                    continue;
                }
                if (wordBreakInternal(next, dictionary, N - i)) {
                    return true;
                }
            }
        }

        seen.put(str.substring(0, N), false);
        return false;
    }
}
