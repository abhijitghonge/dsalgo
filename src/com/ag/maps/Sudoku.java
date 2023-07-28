package com.ag.maps;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class Sudoku {

    /**
     * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
     * @param args
     */
    public static void main(String[] args) {
        String[] sudoku = new String[]{"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        Sudoku game = new Sudoku();


        System.out.println("Is Valid:"+game.isValidSudoku(Arrays.stream(sudoku).collect(Collectors.toList())));

    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isValidSudoku(final List<String> A) {
        char[][] sudoku = buildMatrix(A);

        return isValidRowWise(sudoku) & isValidColumnWise(sudoku) & isValid3x3Grid(sudoku);
    }

    private char[][] buildMatrix(final List<String> A) {
        char[][] sudoku = new char[A.size()][A.get(0).length()];
        int r = 0;
        for (String row : A) {
            int c = 0;
            for (char ch : row.toCharArray()) {
                //System.out.printf("%c ", ch);
                sudoku[r][c] = ch;
                c++;
            }
            //System.out.println();
            r++;
        }

        return sudoku;
    }

    private int isValidRowWise(final char[][] sudoku) {
        Map<Character, Integer> lookup = new HashMap<>();
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                char ch = sudoku[i][j];
                if (isSudokuRange(ch) && hasMultipleOccur(ch, lookup)) {
                    return 0;
                }
                lookup.compute(ch, (k, v) -> isNull(v) ? 1 : v + 1);
            }
            lookup.clear();
        }
        return 1;
    }

    private int isValidColumnWise(final char[][] sudoku) {
        Map<Character, Integer> lookup = new HashMap<>();
        for (int j = 0; j < sudoku[0].length; j++) {
            for (int i = 0; i < sudoku.length; i++) {
                char ch = sudoku[i][j];
                if (isSudokuRange(ch) && hasMultipleOccur(ch, lookup)) {
                    return 0;
                }
                lookup.compute(ch, (k, v) -> isNull(v) ? 1 : v + 1);
            }
            lookup.clear();
        }
        return 1;
    }

    private int isValid3x3Grid(final char[][] sudoku) {
        List<HashMap<Character, Integer>> grids = emptyGrids();

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                char ch = sudoku[i][j];

                int gridNo = gridFor(i, j);
                /*if(ch == '3' ){
                    System.out.printf("ch: %c, grid#: %d %n", ch, gridNo);
                }*/
                Map<Character, Integer> lookup = grids.get(gridNo);

                if (isSudokuRange(ch) && hasMultipleOccur(ch, lookup)) {
                    return 0;
                }
                lookup.compute(ch, (k, v) -> isNull(v) ? 1 : v + 1);
            }
        }
        return 1;

    }

    private List<HashMap<Character, Integer>> emptyGrids() {
        List<HashMap<Character, Integer>> emptyGrids = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            HashMap<Character, Integer> grid = new HashMap<>();

            emptyGrids.add(grid);
        }

        return emptyGrids;
    }

    private int gridFor(int i, int j) {
        if ((i >= 0 && i <= 2) && (j >= 0 && j <= 2)) {
            return 0;
        } else if ((i >= 3 && i <= 5) && (j >= 0 && j <= 2)) {
            return 1;
        } else if ((i >= 6 && i <= 9) && (j >= 0 && j <= 2)) {
            return 2;
        } else if ((i >= 0 && i <= 2) && (j >= 3 && j <= 5)) {
            return 3;
        } else if ((i >= 3 && i <= 5) && (j >= 3 && j <= 5)) {
            return 4;
        } else if ((i >= 6 && i <= 9) && (j >= 3 && j <= 5)) {
            return 5;
        } else if ((i >= 0 && i <= 2) && (j >= 6 && j <= 8)) {
            return 6;
        } else if ((i >= 3 && i <= 5) && (j >= 6 && j <= 8)) {
            return 7;
        } else {
            return 8;
        }
    }

    private boolean isSudokuRange(char ch) {
        return ch >= '1' && ch <= '9';
    }

    private boolean hasMultipleOccur(char ch, Map<Character, Integer> lookup) {
        return lookup.containsKey(ch);
    }


}
