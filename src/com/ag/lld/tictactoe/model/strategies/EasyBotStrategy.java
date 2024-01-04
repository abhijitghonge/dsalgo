package com.ag.lld.tictactoe.model.strategies;

import com.ag.lld.tictactoe.exceptions.BotMoveException;
import com.ag.lld.tictactoe.model.Grid;
import com.ag.lld.tictactoe.model.Move;
import com.ag.lld.tictactoe.model.PlayerInGame;

import java.util.Objects;

public class EasyBotStrategy implements PlayingStrategy{


    @Override
    public Move makeMove(Grid grid) throws BotMoveException {
        PlayerInGame[][] matrix = grid.getMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(Objects.isNull(matrix[i][j])){
                    return new Move(i, j);
                }
            }
        }
        throw new BotMoveException("No Cell to make a move!!");
    }
}
