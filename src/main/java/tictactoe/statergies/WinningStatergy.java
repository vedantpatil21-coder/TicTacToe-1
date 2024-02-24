package tictactoe.statergies;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;

public interface WinningStatergy {
    boolean checkWinner(Move move, Board board);

    void undo(Board board, Move lastMove);
}
