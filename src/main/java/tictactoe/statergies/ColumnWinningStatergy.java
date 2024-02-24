package tictactoe.statergies;

import tictactoe.models.Board;
import tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStatergy implements WinningStatergy{

    Map<Integer,Map<Character,Integer>> map = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {

        int col = move.getCell().getColumn();
        char symbol = move.getPlayer().getSymbol();

        if(!map.containsKey(col)){
            map.put(col,new HashMap<>());
        }

        Map<Character,Integer> colMap = map.get(col);

        if(!colMap.containsKey(symbol)){
            colMap.put(symbol,0);
        }

        colMap.put(symbol,colMap.get(symbol)+1);

        if(board.getBoard().size()==(colMap.get(symbol))){
            return true;
        }



        return false;
    }

    @Override
    public void undo(Board board, Move lastMove) {
        int col = lastMove.getCell().getColumn();
        char symbol = lastMove.getPlayer().getSymbol();

        Map<Character,Integer> colMap = map.get(col);
        colMap.put(symbol,colMap.get(symbol)-1);

    }
}
