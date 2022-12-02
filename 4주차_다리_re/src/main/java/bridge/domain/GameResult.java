package bridge.domain;

import bridge.enums.GameStatus;

public class GameResult {
    private int trialCount;
    private GameStatus gameStatus;

    public GameResult(){

    }

    public void resetGame(){

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
