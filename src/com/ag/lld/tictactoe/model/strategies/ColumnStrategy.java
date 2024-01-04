package com.ag.lld.tictactoe.model.strategies;

import com.ag.lld.tictactoe.model.*;
import com.ag.lld.tictactoe.model.enums.WinningStrategyType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ColumnStrategy implements WinningStrategy {

    private final WinningStrategy parent ;
    private Map<Integer, HashMap<PlayerInGame, Integer>> winnerStats;

    public ColumnStrategy(WinningStrategy parentStrategy){
        this.parent = parentStrategy;
        this.winnerStats = new HashMap<>();
    }

    public ColumnStrategy() {
        this(null);
    }

    @Override
    public boolean recordWinner(PlayerInGame player, Move move) {
        if(!Objects.isNull(parent)){
            return parent.recordWinner(player, move) || recordWinnerInternal(player, move);
        }
        return recordWinnerInternal(player, move);
    }

    private boolean recordWinnerInternal(PlayerInGame player, Move move){
        int column = move.getColumn();

        winnerStats.computeIfAbsent(column, k->new HashMap<>());
        HashMap<PlayerInGame, Integer> countMap = winnerStats.get(column);
        countMap.compute(player, (k,v)->v==null?1:v+1);
        return countMap.get(player) == move.getGridSnap().getMatrix().length;
    }


}
