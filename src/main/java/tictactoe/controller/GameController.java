package tictactoe.controller;

import tictactoe.exceptions.moreThanOneBotException;
import tictactoe.exceptions.playerCountMisMatchException;
import tictactoe.exceptions.validateUniqueSymbolNotFoundforPlayerException;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.statergies.WinningStatergy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> playerList, List<WinningStatergy> winningStatergies) throws moreThanOneBotException, playerCountMisMatchException, validateUniqueSymbolNotFoundforPlayerException {
        return Game.getBuilder().setDimension(dimension).setPlayer(playerList).setWinningStatergies(winningStatergies).Build();

    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void undo(Game game) {
        game.undo();
    }


}
