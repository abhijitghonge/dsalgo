package com.ag.lld.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Game implements Prototype{
    private long id;
    private int gridSize;
    private List<String> players;

    public long getId() {
        return id;
    }

    public int getGridSize() {
        return gridSize;
    }

    public List<String> getPlayers() {
        return players;
    }

    public Game(long id, int gridSize, List<String> players){
        this.id = id;
        this.gridSize = gridSize;
        players = new ArrayList<>(players);
    }
    public Game(Game copyFrom){
        this(copyFrom.id, copyFrom.gridSize, copyFrom.getPlayers());
    }

    @Override
    public Prototype clone() {
        return new Game(this);
    }
}
