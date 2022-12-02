package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Boolean> playerAnswers;

    public Player(){
        playerAnswers = new ArrayList<>();
    }

    public void addPlayerAnswer(boolean result){
        playerAnswers.add(result);
    }

    public boolean isFailedGame(){
        return playerAnswers.contains(false);
    }

    public boolean isFinished(int size){
        return !isFailedGame() && playerAnswers.size() == size;
    }

    public List<Boolean> getPlayerAnswers(){
        return playerAnswers;
    }

    public void clearAnswers(){
        playerAnswers.clear();
    }
}
