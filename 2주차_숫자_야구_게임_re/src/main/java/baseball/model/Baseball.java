package baseball.model;

import baseball.domain.Player;
import baseball.domain.RandomNumbers;

public class Baseball {

    private final RandomNumbers randomNumbers;
    private Player player;

    public Baseball(){
        randomNumbers = new RandomNumbers();
    }

    public void createPlayer(String input){
    }

    public int countStrikeWithPlayer(){
        return 0;
    }

    public int countBallWithPlayer(){
        return 0;
    }

    public boolean isThreeStrike(){
        return false;
    }
}
