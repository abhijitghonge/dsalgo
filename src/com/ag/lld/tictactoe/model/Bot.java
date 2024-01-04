package com.ag.lld.tictactoe.model;

import com.ag.lld.tictactoe.exceptions.BotMoveException;
import com.ag.lld.tictactoe.model.enums.DifficultyLevel;
import com.ag.lld.tictactoe.model.enums.PlayerType;
import com.ag.lld.tictactoe.model.strategies.PlayingStrategy;

public class Bot extends Player{

    private DifficultyLevel playingLevel;

    private PlayingStrategy playingStrategy;



    public Bot(String name, int id, DifficultyLevel playingLevel){
        super(name, id, PlayerType.BOT);
        this.playingLevel = playingLevel;
        this.playingStrategy = BotStrategyFactory.getBotStrategy(playingLevel);
    }

    public Move getMove(Game game) throws BotMoveException {
        return playingStrategy.makeMove(game.getCurrentGrid());

    }
}
