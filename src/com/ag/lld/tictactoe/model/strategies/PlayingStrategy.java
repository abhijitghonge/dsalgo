package com.ag.lld.tictactoe.model.strategies;

import com.ag.lld.tictactoe.exceptions.BotMoveException;
import com.ag.lld.tictactoe.model.Grid;
import com.ag.lld.tictactoe.model.Move;

public interface PlayingStrategy {

    Move makeMove(Grid grid) throws BotMoveException;
}
