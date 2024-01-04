package com.ag.lld.tictactoe.model;

import com.ag.lld.tictactoe.model.enums.WinningStrategyType;

import java.util.EnumMap;
import java.util.Objects;

public class Grid {
    private PlayerInGame[][] matrix;

    private EnumMap<WinningStrategyType, PlayerInGame> winners;


    public Grid(int size) {
        this.matrix = new PlayerInGame[size][size];

        this.winners = new EnumMap<>(WinningStrategyType.class);
    }

    public Grid(PlayerInGame[][] matrix){
        this.matrix = matrix;
    }

    public PlayerInGame[][] getMatrix() {
        return matrix;
    }

    public EnumMap<WinningStrategyType, PlayerInGame> getWinner() {
        return winners;
    }

    public void display() {
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                System.out.print("||");
                if(Objects.isNull(matrix[i][j])){
                    System.out.print("-");
                }else{
                    System.out.printf("%s", matrix[i][j].getSymbol());
                }
            }
            System.out.println("||");
        }
    }
}
