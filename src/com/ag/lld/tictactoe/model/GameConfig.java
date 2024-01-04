package com.ag.lld.tictactoe.model;

import com.ag.lld.tictactoe.model.enums.WinningStrategyType;

import java.util.List;
import java.util.Map;

public class GameConfig {

    private List<PlayerInGame> players;
    private int gridSize;
    private List<WinningStrategyType> winningStrategies;

    public GameConfig(List<PlayerInGame> players, int gridSize, List<WinningStrategyType> winningStrategies) {
        this.players = players;
        this.gridSize = gridSize;
        this.winningStrategies = winningStrategies;
    }

    public List<PlayerInGame> getPlayers() {
        return players;
    }

    public int getGridSize() {
        return gridSize;
    }

    public List<WinningStrategyType> getWinningStrategies() {
        return winningStrategies;
    }
}
