package com.ag.lld.tictactoe.controllers;

import com.ag.lld.tictactoe.exceptions.BotMoveException;
import com.ag.lld.tictactoe.model.*;
import com.ag.lld.tictactoe.model.enums.GameState;
import com.ag.lld.tictactoe.model.enums.WinningStrategyType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GameController {
    private final Map<Integer, Game> games = new HashMap<>();

    public int startGame(GameConfig gameConfig){
        Game.GameBuilder gameBuilder = Game.builder().addPlayers(gameConfig.getPlayers());

        for(WinningStrategyType strategyType: gameConfig.getWinningStrategies()){
            gameBuilder.addWinningStrategy(strategyType);
        }

        Game game = gameBuilder.setGridSize(gameConfig.getGridSize()).build();
        games.put(game.getId(), game);
        return game.getId();
    }

    public boolean makeMove(int gameId, int playerId, int row, int column){
        Game current = games.get(gameId);
        return current.makeMove(playerId, row, column);
    }

    public Optional<PlayerInGame> hasWinner(int gameId){
        return Optional.ofNullable(games.get(gameId).getWinner());
    }

    public boolean hasEnded(int game1) {
        return games.get(game1).getStatus() != GameState.IN_PROGRESS;
    }

    public void displayBoard(int game) {
        games.get(game).displayBoard();
    }

    public Player nextPlayerToMove(int game) {
        return games.get(game).nextPlayerToMove();
    }


    public Move getbotMove(int game, Player player) throws BotMoveException {
        if(player instanceof Bot){
            Bot bot = (Bot) player;
            return bot.getMove(games.get(game));
        }

        //you should not come here
        throw new BotMoveException("Invalid! Player is not a bot:["+player.getName()+"]");
    }
}
