package com.ag.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringChain {

    private class Pair<K,V>{
        K key;
        V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public int longestStrChain(String[] words) {
        Map<Integer, Set<String>> lookup = new HashMap<>();
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(String word: words){
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
            lookup.compute(word.length(), (k,v)->{
                if(v==null){
                    v = new HashSet<>();
                }
                v.add(word);
                return v;
            } );
        }

        int chain=1;

        for(String word: words){
            int currChain=1;
            int nextLength = word.length()+1;
            String probable = word;

            while(lookup.containsKey(nextLength)){
                Pair<Boolean, String> subSequenceDetails = getSubSequenceDetails(probable, lookup.get(nextLength));
                if(subSequenceDetails.key){
                    probable = subSequenceDetails.value;
                    currChain++;
                    nextLength++;
                }else{
                    break;
                }
            }

            chain = Math.max(currChain, chain);
        }

        return chain;
    }

    private Pair<Boolean, String> getSubSequenceDetails(String probable, Set<String> words){
        for(String word: words){
            int i=0, j=0;
            for(; i<probable.length()&&j<word.length();){
                if(probable.charAt(i)==word.charAt(j)){
                    i++; j++;
                }else{
                    j++;
                }
            }
            if(i==probable.length()) return new Pair<>(true, word);
        }

        return new Pair<>(false, null);
    }
}
