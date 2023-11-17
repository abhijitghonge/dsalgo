package com.ag.backtracking;

import java.util.Scanner;

public class Sudoku {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] sudoku = new char[9][9];
        for(int i=0; i<9; i++){
            String row = sc.next();
            int j=0;
            for(char ch: row.toCharArray()){
                sudoku[i][j] = ch;
                j++;
            }
        }

        Sudoku puzzle = new Sudoku();
        boolean result = puzzle.solve(sudoku, 0);
        System.out.printf("Solved:%b%n",result );
        for(int i=0; i<9;i++){
            for(int j=0; j<9; j++){
                System.out.printf("%c ",sudoku[i][j] );
            }
            System.out.println();
        }
    }
    private boolean canPlaceAt(char[][] A, int pos, char digit) {
        int i = pos / 9;
        int j = pos % 9;

        for (int k = 0; k < 9; k++) {
            if (A[i][k] == digit) {
                return false;
            }
        }

        for (int k = 0; k < 9; k++) {
            if (A[k][j] == digit) {
                return false;
            }
        }
        int boxi = (int) (i / 3);
        int row = boxi * 3;
        int boxj = (int) (j / 3);
        int col = boxj * 3;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (A[row + r][col + c] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean solve(char[][] A, int pos) {
        if (pos == 81) {
            return true;
        }
        int i = pos / 9;
        int j = pos % 9;

        if (A[i][j] != '.') {
            return solve(A, pos + 1);
        }

        for (int k = 1; k <= 9; k++) {
            char ch = (char) (k + '0');
            //System.out.printf("s:%c", ch);
            if (canPlaceAt(A, pos, ch )) {
                A[i][j] = ch;
                if (solve(A, pos + 1)) {
                    return true;
                }
                A[i][j] = '.';
            }
        }

        return false;
    }
}
