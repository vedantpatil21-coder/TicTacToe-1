package tictactoe.models;

import tictactoe.exceptions.moreThanOneBotException;
import tictactoe.exceptions.playerCountMisMatchException;
import tictactoe.exceptions.validateUniqueSymbolNotFoundforPlayerException;
import tictactoe.statergies.WinningStatergy;

import java.util.*;

public class Game {

    private List<Player> player;

    private Board board;
    private List<Move> moves;
    private GameState gameState;

    private List<WinningStatergy> winningStatergies;

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    private Player winner;

    private Game(int dimension,List<Player> player, List<WinningStatergy> winningStatergies) {
        this.board=new Board(dimension);
        this.player = player;
        this.winningStatergies = winningStatergies;
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex=0;
        this.moves=new ArrayList<>();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void displayBoard() {
        board.displayBoard();
    }

    public void makeMove() {
        Player pi = player.get(nextPlayerIndex);
        Cell cell = pi.makeMove(board);
        Move move = new Move(cell,pi);
        moves.add(move);

        if(checkWinner(move,board)){
            gameState= GameState.SUCCESS;
            winner = pi;
            return;
        }
        if(moves.size() == board.getDimension()*board.getDimension()){
            gameState = GameState.DRAW;
            return;
        }
        nextPlayerIndex++;
        nextPlayerIndex = nextPlayerIndex % player.size();
    }

    private boolean checkWinner(Move move, Board board) {
        for(WinningStatergy ws : winningStatergies){
            if(ws.checkWinner(move,board)) {
                return true;
            }
        }
        return false;
    }

    public void undo() {
        if(moves.size()==0){
            System.out.println("no moves to undo!!");
            return;
        }

        Move lastMove = moves.get(moves.size()-1);
        moves.remove(lastMove);
        Cell cell = lastMove.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

        for(WinningStatergy winningStatergy :winningStatergies){
            winningStatergy.undo(board,lastMove);
        }

        if(nextPlayerIndex!=0){
            nextPlayerIndex--;
        }else{
            nextPlayerIndex = player.size()-1;
        }
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStatergy> winningStatergies;

        private Builder() {
            this.dimension = 0;
            this.players = new ArrayList<>();
            this.winningStatergies = new ArrayList<>();
        }
        public Game Build() throws moreThanOneBotException, validateUniqueSymbolNotFoundforPlayerException, playerCountMisMatchException {
            validateBotCount();
            validateUniqueSymbolforPlayer();
            validateDimensionAndPlayerCount();
            return new Game(dimension,players,winningStatergies);

        }

        private void validateDimensionAndPlayerCount() throws playerCountMisMatchException {
            if(players.size()!=(dimension-1)){
                throw new playerCountMisMatchException();
            }
        }

        private void validateUniqueSymbolforPlayer() throws validateUniqueSymbolNotFoundforPlayerException {
            Set<Character> symbols = new HashSet<>();
            for(Player player : players){
                if(symbols.contains(player.getSymbol())){
                    throw new validateUniqueSymbolNotFoundforPlayerException();

                }
            }
        }

        private void validateBotCount() throws moreThanOneBotException {
            int botCount=0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }

            }
            if(botCount>1){
                throw new moreThanOneBotException();
            }
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayer(List<Player> player) {
            this.players = player;
            return this;
        }

        public Builder setWinningStatergies(List<WinningStatergy> winningStatergies) {
            this.winningStatergies = winningStatergies;
            return this;
        }
    }


    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMove() {
        return moves;
    }

    public void setMove(List<Move> move) {
        this.moves = move;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    private int nextPlayerIndex;

}
