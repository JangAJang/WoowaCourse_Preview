package bridge.domain;

import bridge.enums.GameStatus;

public class GameResult {
    private int trialCount;
    private GameStatus gameStatus;

    public GameResult(){
        trialCount = `;
        gameStatus = GameStatus.GOING;
    }

    public void resetGame(){
        trialCount++;
    }

    public void failGame(){
        gameStatus = GameStatus.QUIT;
    }

    public boolean isQuit(){
        return gameStatus.equals(GameStatus.QUIT);
    }

    public int getTrialCount(){
        return trialCount;
    }

}
