package tictactoe.models;

public class Cell {

    public void display() {
        if(CellState.FILLED.equals(cellState)){
            System.out.print("| " + player.getSymbol() + " |");
        }else {
            System.out.print("| - |");
        }
    }

    public int getRow() {
        return row;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    private int row;
    private int column;
   private CellState cellState;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellState=CellState.EMPTY;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Player player;
}
