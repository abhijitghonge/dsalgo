package com.ag.lld.tictactoe.model;

import com.ag.lld.tictactoe.model.enums.PlayerType;

public class Player {
    private String name;
    private int id;
    private PlayerType playerType;

    public Player( String name, int id) {
        this(name, id, PlayerType.HUMAN);
    }

    public Player( String name, int id, PlayerType type){
        this.name = name;
        this.id = id;
        this.playerType = type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}
