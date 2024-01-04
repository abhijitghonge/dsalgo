package com.ag.lld.tictactoe.model;

import com.ag.lld.tictactoe.model.enums.GameState;
import com.ag.lld.tictactoe.model.enums.WinningStrategyType;
import com.ag.lld.tictactoe.model.strategies.ColumnStrategy;
import com.ag.lld.tictactoe.model.strategies.RowStrategy;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class Game {
    private int id;
    private Grid currentGrid;
    private final List<Move> moves;
    private final List<PlayerInGame> players;
    private final WinningStrategy winningStrategy;
    private GameState status;
    private PlayerInGame winner;


    private int nextPlayerIndex;

    private Game(Grid grid, List<PlayerInGame> players, WinningStrategy winningStrategy){
        this.currentGrid = grid;
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.moves = new ArrayList<>();
        this.status = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
    }


    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public Grid getCurrentGrid() {
        return currentGrid;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<PlayerInGame> getPlayers() {
        return players;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public int getId() {
        return id;
    }

    public boolean makeMove(int playerId, int row, int column) {
        PlayerInGame[][] matrix = currentGrid.getMatrix();
        PlayerInGame currentPlayer = players.get(playerId);

        matrix[row][column] = currentPlayer;

        Move currentMove = new Move(new Grid(copy(matrix)), row, column);
        moves.add(currentMove);
        if(winningStrategy.recordWinner(currentPlayer, currentMove)){
            this.status = GameState.WIN;
            winner = currentPlayer;
        }else if(isFilled(currentGrid)){
            this.status = GameState.DRAW;
        }

        nextPlayerIndex = (nextPlayerIndex+1)%players.size();

        return true;
    }

    private boolean isFilled(Grid currentGrid) {
        PlayerInGame[][] matrix = currentGrid.getMatrix();
        for (PlayerInGame[] playerInGames : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (isNull(playerInGames[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private PlayerInGame[][] copy(PlayerInGame[][] matrix) {
        PlayerInGame[][] copy = new PlayerInGame[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, matrix.length);
        }
        return copy;
    }

    public PlayerInGame getWinner() {
        return winner;
    }

    public void setWinner(PlayerInGame winner) {
        this.winner = winner;
    }

    public GameState getStatus() {
        return status;
    }

    public void displayBoard() {
        currentGrid.display();
    }

    public Player nextPlayerToMove() {
        return players.get(nextPlayerIndex).getPlayer();
    }

    public static class GameBuilder {
        private int gridSize;
        private List<PlayerInGame> players = new ArrayList<>();
        private WinningStrategy winningStrategy;

        public GameBuilder setGridSize(int gridSize) {
            this.gridSize = gridSize;

            return this;
        }

        public GameBuilder addPlayers(List<PlayerInGame> players) {
            this.players.addAll(players);
            return this;
        }

        public GameBuilder addWinningStrategy(WinningStrategyType strategy) {
            switch (strategy){
                case ROW:
                    this.winningStrategy =  isNull(this.winningStrategy)? new RowStrategy():new RowStrategy(this.winningStrategy);
                case COLUMN:
                    this.winningStrategy =  isNull(this.winningStrategy)? new ColumnStrategy():new ColumnStrategy(this.winningStrategy);

            }
            return this;
        }

        public Game build(){
            if(players.size()>=gridSize){
                String message = "# of players["+players.size()+"] should be less than grid size:["+gridSize+"]";
                throw new InvalidGameException(message);
            }

            return new Game(new Grid(gridSize), this.players, this.winningStrategy);
        }
    }
}
