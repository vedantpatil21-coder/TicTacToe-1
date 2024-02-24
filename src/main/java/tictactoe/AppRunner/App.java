package tictactoe.AppRunner;

import tictactoe.controller.GameController;
import tictactoe.exceptions.moreThanOneBotException;
import tictactoe.exceptions.playerCountMisMatchException;
import tictactoe.exceptions.validateUniqueSymbolNotFoundforPlayerException;
import tictactoe.models.*;
import tictactoe.statergies.ColumnWinningStatergy;
import tictactoe.statergies.DaigonalWinningStatergy;
import tictactoe.statergies.RowWinningStrategy;
import tictactoe.statergies.WinningStatergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws moreThanOneBotException, playerCountMisMatchException, validateUniqueSymbolNotFoundforPlayerException {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        int dimension =3;
        List<Player> playerList = new ArrayList<>();
        List<WinningStatergy> winningStatergies = new ArrayList<>();

        playerList.add(new Player('X',"vedant",21, PlayerType.HUMAN));
        playerList.add(new Bot('O',"alexa",23, PlayerType.BOT, DifficultyLevel.EASY));

        winningStatergies.add(new RowWinningStrategy());
        winningStatergies.add(new ColumnWinningStatergy());
        winningStatergies.add(new DaigonalWinningStatergy());

        Game game = gameController.startGame(dimension,playerList,winningStatergies);
        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            game.displayBoard();
            System.out.println("Does anyOne wants to undo? (y/n)");
            String undo = scanner.next();
            if(undo.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue;
            }

            gameController.makeMove(game);
        }

        if(GameState.SUCCESS.equals(game.getGameState())){
            System.out.println(game.getWinner().getName() + " congrats ur the winner :) you won the Game");
        }
        if(GameState.DRAW.equals(game.getGameState())){
            System.out.println(" match tied!!!");
        }


    }
}
