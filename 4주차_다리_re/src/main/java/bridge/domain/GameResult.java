package bridge.domain;

import bridge.enums.GameStatus;

public class GameResult {
    private int trialCount;
    private GameStatus gameStatus;

    public GameResult(){
        trialCount = 1;
        gameStatus = GameStatus.GOING;
    }

    public void resetGame(){
        trialCount++;
    }

    public void failGame(){

    }

    public boolean isQuit(){
        return false;
    }

    public int getTrialCount(){
        return 0;
    }

}
