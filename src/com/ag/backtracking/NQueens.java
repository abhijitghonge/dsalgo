package com.ag.backtracking;

import java.util.ArrayList;

public class NQueens {

    public static void main(String[] args) {
        NQueens puzzle = new NQueens();
        ArrayList<ArrayList<String>> results = puzzle.solveNQueens(4);

        for (ArrayList<String> result : results) {
            System.out.println("[");
            for (String rank : result) {
                System.out.println(rank);
            }
            System.out.println("]");
        }
    }

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> results = new ArrayList<>();

        boolean[] diagonal1 = new boolean[2 * A - 1];
        boolean[] diagonal2 = new boolean[2 * A - 1];
        boolean[] columns = new boolean[A];

        solve(A, results, new ArrayList<>(), 0, diagonal1, diagonal2, columns);
        return results;
    }

    private ArrayList<String> newChessboard(int size) {
        ArrayList<String> newBoard = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            StringBuilder blankRow = new StringBuilder();
            for (int j = 0; j < size; j++) {
                blankRow.append('.');
            }
            newBoard.add(blankRow.toString());
        }
        return newBoard;
    }

    private void addQueenAt(int N, ArrayList<String> chessboard, int row, int col, boolean[] diagonal1, boolean[] diagonal2, boolean[] columns) {
        StringBuilder rank = new StringBuilder(chessboard.get(row));
        rank.setCharAt(col, 'Q');
        chessboard.set(row, rank.toString());
        columns[col] = true;
        diagonal1[col - row + N - 1] = true;
        diagonal2[col + row] = true;
    }

    private void removeQueenAt(int N, ArrayList<String> chessboard, int row, int col, boolean[] diagonal1, boolean[] diagonal2, boolean[] columns) {
        StringBuilder rank = new StringBuilder(chessboard.get(row));
        rank.setCharAt(col, '.');
        chessboard.set(row, rank.toString());
        columns[col] = false;
        diagonal1[col - row + N - 1] = false;
        diagonal2[col + row] = false;
    }

    private boolean canPlaceAt(int N, int row, int col, boolean[] diagonal1, boolean[] diagonal2, boolean[] columns) {
        if (diagonal1[col - row + N - 1]) {
            return false;
        } else if (diagonal2[col + row]) {
            return false;
        } else {
            return !columns[col];
        }

    }

    private void solve(int N, ArrayList<ArrayList<String>> results, ArrayList<String> chessboard, int row, boolean[] diagonal1, boolean[] diagonal2, boolean[] columns) {

        if (row == N) {
           // System.out.println("[");
            for (String rank : chessboard) {
               //System.out.printf("r:%s, c:%b%n", rank, rank.contains("Q"));
                if (!rank.contains("Q")) {
                    return;
                }
            }
            //System.out.println("]");
            results.add(new ArrayList<>(chessboard));
            return;
        }

        for (int col = 0; col < N; col++) {
            if(row == 0){
                //new board
                chessboard = newChessboard(N);
            }
            if (canPlaceAt(N, row, col, diagonal1, diagonal2, columns)) {
                addQueenAt(N, chessboard, row, col, diagonal1, diagonal2, columns);
                solve(N, results, chessboard, row + 1, diagonal1, diagonal2, columns);
                removeQueenAt(N, chessboard, row, col, diagonal1, diagonal2, columns);
            }
        }
    }

}
