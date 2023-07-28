package com.ag.maps;

import java.util.*;

public class LongestZeroSum {
    public static void main(String[] args) {

    }

    public int solve(int[] A) {

        long[] pfsums = createPrefixSums(A);

        Map<Long, List<Integer>> repeatedSums = buildRepeatedSums(pfsums);

        int maxLength = 0;

        for (Map.Entry<Long, List<Integer>> entry : repeatedSums.entrySet()) {

            Long sum = entry.getKey();
            List<Integer> indices = entry.getValue();

            if (sum == 0) {
                //last index is maximum
                maxLength = Math.max(maxLength, indices.get(indices.size() - 1) + 1);
            } else if (indices.size() >= 2) {
                //non-zero repeated sums
                maxLength = Math.max(maxLength, indices.get(indices.size() - 1) - indices.get(0));
            }

        }

        return maxLength;

    }

    private Map<Long, List<Integer>> buildRepeatedSums(long[] pfsums) {
        Map<Long, List<Integer>> repeatedSums = new HashMap<>();

        for (int i = 0; i < pfsums.length; i++) {

            List<Integer> indices= repeatedSums.getOrDefault(pfsums[i], new ArrayList<>());

            indices.add(i);

            repeatedSums.put(pfsums[i], indices);
        }

        return repeatedSums;
    }

    private long[] createPrefixSums(int[] A) {
        long[] pfsums = new long[A.length];

        pfsums[0] = A[0]; //first

        for (int i = 1; i < A.length; i++) {
            pfsums[i] = A[i] + pfsums[i - 1];
        }

        return pfsums;
    }
}
