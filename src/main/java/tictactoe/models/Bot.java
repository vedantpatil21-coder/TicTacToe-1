package tictactoe.models;

import tictactoe.botplayingstatergies.BotPlayingStatergies;
import tictactoe.botplayingstatergies.BotPlayingStatergiesFactory;

public class Bot extends Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStatergies botPlayingStatergies;

    public Bot(char symbol, String name, int id, PlayerType playerType,DifficultyLevel difficultyLevel) {
        super(symbol, name, id, playerType);
        this.difficultyLevel=difficultyLevel;
        this.botPlayingStatergies = BotPlayingStatergiesFactory.getBotPlayingStatergyLevelForPlayer(difficultyLevel);
    }

    @Override
    public Cell makeMove(Board board) {
        System.out.println("Be Ready !! Bot making move");
        Cell cell = botPlayingStatergies.makeMove(board);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);

        return cell;
    }
}
