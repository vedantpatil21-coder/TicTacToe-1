package tictactoe.botplayingstatergies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.CellState;

import java.util.List;

public class EasyPlayingStatergy implements BotPlayingStatergies {

    @Override
    public Cell makeMove(Board board) {
        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row){
                if(CellState.EMPTY.equals(cell.getCellState())){
                    return cell;
                }
            }
        }

        return null;
    }
}
