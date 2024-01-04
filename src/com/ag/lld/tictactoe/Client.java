package com.ag.lld.tictactoe;

import com.ag.lld.tictactoe.controllers.GameController;
import com.ag.lld.tictactoe.model.*;
import com.ag.lld.tictactoe.model.enums.DifficultyLevel;
import com.ag.lld.tictactoe.model.enums.PlayerType;
import com.ag.lld.tictactoe.model.enums.WinningStrategyType;

import java.util.*;

import static com.ag.lld.tictactoe.model.enums.WinningStrategyType.*;

public class Client {
    public static void main(String[] args)  throws Exception{
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        System.out.println("Game is starting");

        try {
            GameConfig gameConfig = createGameConfig();
            int game = gameController.startGame(gameConfig);

            gameController.displayBoard(game);
            while (!gameController.hasEnded(game)) {
                Player currentMovePlayer = gameController.nextPlayerToMove(game);
                System.out.println("It is " + currentMovePlayer.getName() + "'s turn. Please make your move");
                int moveRow =-1, moveColumn = -1;
                if(currentMovePlayer.getPlayerType() == PlayerType.BOT){
                    Move move = gameController.getbotMove(game, currentMovePlayer);
                    moveRow = move.getRow();
                    moveColumn = move.getColumn();
                }else{
                    System.out.println("Please mention the [row column] in which you want to move.");
                    moveRow = sc.nextInt();
                    moveColumn = sc.nextInt();
                }

                gameController.makeMove(game, currentMovePlayer.getId(), moveRow, moveColumn);
                /*System.out.println("Do anyone wants to undo ? (y/n)");
                String undoAnswer = sc.next();
                if (undoAnswer.equals("y")) {
                    gameController.undo(game);
                }*/
                gameController.displayBoard(game);
            }

            System.out.println("The Game is finished!");
            Optional<PlayerInGame> winner = gameController.hasWinner(game);

            if (!winner.isPresent()) {
                System.out.println("The Result is DRAW!!!!");
            } else {
                System.out.println("The Winner is " + winner.get().getPlayer().getName());
            }

        } catch (Exception e) {
            throw e;
//            System.out.println("Game has stopped working!");
        }
    }

    private static GameConfig createGameConfig() {
        List<PlayerInGame> players = new ArrayList<>();
        PlayerInGame p1 = new PlayerInGame(new Player("Bob", 0), "x");
        players.add( p1);

        PlayerInGame p2 = new PlayerInGame(new Bot("Gemini", 1, DifficultyLevel.EASY), "0");
        players.add( p2);

        List<WinningStrategyType> strategies = new ArrayList<>();
        strategies.add(COLUMN);
        strategies.add(ROW);
        strategies.add(DIAGONAL);

        return new GameConfig(players, 3, strategies);
    }
}
