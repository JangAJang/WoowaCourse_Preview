package bridge.domain;

import java.util.List;

public class Player {

    List<Boolean> playerAnswers;

    public Player(){

    }

    public void addPlayerAnswer(boolean result){

    }

    public boolean isFailedGame(){
        return false;
    }

    public boolean isFinished(int size){
        return false;
    }

    public List<Boolean> getPlayerAnswers(){
        return playerAnswers;
    }

    public void clearAnswers(){

    }
}
