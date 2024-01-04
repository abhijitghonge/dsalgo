package com.ag.lld.tictactoe.model;

import com.ag.lld.tictactoe.model.enums.DifficultyLevel;
import com.ag.lld.tictactoe.model.strategies.EasyBotStrategy;
import com.ag.lld.tictactoe.model.strategies.PlayingStrategy;

public class BotStrategyFactory {

    public static PlayingStrategy getBotStrategy(DifficultyLevel botLevel){
        return new EasyBotStrategy();
    }
}
