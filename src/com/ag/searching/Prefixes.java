package com.ag.searching;

import java.util.ArrayList;

public class Prefixes {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<String> A, String B) {
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(-1);
        indexes.add(-1);

        ArrayList<Integer> prefixes = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (B.contains(A.get(i))) {
                prefixes.add(i);
            }
        }


        if (!prefixes.isEmpty()) {
            indexes.add(prefixes.get(0));
            indexes.add(prefixes.get(prefixes.size() - 1));
        }
        return indexes;

    }
}
