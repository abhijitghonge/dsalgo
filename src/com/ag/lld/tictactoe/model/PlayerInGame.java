package com.ag.lld.tictactoe.model;

public class PlayerInGame {
    private final Player player;
    private final String symbol;

    public PlayerInGame(Player player, String symbol) {
        this.player = player;
        this.symbol = symbol;
    }

    public Player getPlayer() {
        return player;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "PlayerInGame{" +
                "player=" + player +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
