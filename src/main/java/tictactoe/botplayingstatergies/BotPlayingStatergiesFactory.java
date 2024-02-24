package tictactoe.botplayingstatergies;

import tictactoe.models.DifficultyLevel;

public class BotPlayingStatergiesFactory {

    public static BotPlayingStatergies getBotPlayingStatergyLevelForPlayer(DifficultyLevel difficultyLevel) {
        return new EasyPlayingStatergy();
    }
}
