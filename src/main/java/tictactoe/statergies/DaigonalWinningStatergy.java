package tictactoe.statergies;

import tictactoe.models.Board;
import tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DaigonalWinningStatergy implements WinningStatergy{
    Map<Character,Integer> leftDaiMap = new HashMap<>();
    Map<Character,Integer> rightDaiMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {

        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        char symbol = move.getPlayer().getSymbol();

        if(row == col){
            if(!leftDaiMap.containsKey(symbol)){
                leftDaiMap.put(symbol,0);
            }
            leftDaiMap.put(symbol,leftDaiMap.get(symbol)+1);

            if(board.getDimension()==(leftDaiMap.get(symbol))){
                return true;
            }
        }

        if((row+col)==board.getDimension()-1){

            if(!rightDaiMap.containsKey(symbol)){
                rightDaiMap.put(symbol,0);
            }
            rightDaiMap.put(symbol,rightDaiMap.get(symbol)+1);

            if(board.getDimension()==(rightDaiMap.get(symbol))){
                return true;
            }

        }


        return false;
    }

    @Override
    public void undo(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getColumn();
        char symbol = lastMove.getPlayer().getSymbol();

        if(row==col){
            leftDaiMap.put(symbol,leftDaiMap.get(symbol)-1);
        }
        if((row+col)==board.getDimension()-1){
            rightDaiMap.put(symbol,rightDaiMap.get(symbol)-1);
        }

    }
}
