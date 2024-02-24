package tictactoe.models;

import java.util.Scanner;

public class Player {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public Player(char symbol, String name, int id, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        scanner = new Scanner(System.in);
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    private char symbol;

    private String name;
    private int id;
    private PlayerType playerType;

    private Scanner scanner;

    public Cell makeMove(Board board) {
        System.out.println(this.name +"! hey,its your turn to make a move ,please enter row and col");
         int row =scanner.nextInt();
         int col = scanner.nextInt();
         while(validateMove(row,col,board)==false){
             System.out.println(this.name +"! hey,its invalid move,pls make a valid move");
             row =scanner.nextInt();
             col = scanner.nextInt();
         }
         Cell cell = board.getBoard().get(row).get(col);
         cell.setCellState(CellState.FILLED);
         cell.setPlayer(this);

        return cell;
    }

    private boolean validateMove(int row, int col, Board board) {
        if(row>=board.getDimension() || row<0){
            return false;
        }
        if(col>= board.getDimension() || col<0){
            return false;
        }
        if(!CellState.EMPTY.equals(board.getBoard().get(row).get(col).getCellState())){
            return false;
        }
        return true;
    }
}
