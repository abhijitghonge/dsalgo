package com.ag.lld.tictactoe.model;

import java.util.Optional;

public interface WinningStrategy {

    boolean recordWinner( PlayerInGame player, Move move);
}
