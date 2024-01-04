package com.ag.lld.tictactoe.model.strategies;

import com.ag.lld.tictactoe.model.Game;
import com.ag.lld.tictactoe.model.Move;
import com.ag.lld.tictactoe.model.PlayerInGame;
import com.ag.lld.tictactoe.model.WinningStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RowStrategy implements WinningStrategy {

    private final WinningStrategy parent ;
    private Map<Integer, HashMap<PlayerInGame, Integer>> winnerStats;

    public RowStrategy(WinningStrategy parentStrategy){

        this.parent = parentStrategy;
        this.winnerStats = new HashMap<>();
    }

    public RowStrategy(){
        this(null);
    }


    @Override
    public boolean recordWinner(PlayerInGame player, Move move) {
        boolean result = true;
        if(!Objects.isNull(parent)){
            return parent.recordWinner(player, move) || recordWinnerInternal(player, move);
        }
        return recordWinnerInternal(player, move);
    }

    private boolean recordWinnerInternal(PlayerInGame player, Move move){
        int row = move.getRow();

        HashMap<PlayerInGame, Integer> countMap = winnerStats.computeIfAbsent(row, k -> new HashMap<>());
        countMap.compute(player, (k,v)->v==null?1:v+1);
        return countMap.get(player) == move.getGridSnap().getMatrix().length;
    }


}
