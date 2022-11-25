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
        player = new Player(input);
    }

    public int countStrikeWithPlayer(){
        return randomNumbers.countStrike(player.getNumbers());
    }

    public int countBallWithPlayer(){
        return 0;
    }

    public boolean isThreeStrike(){
        return false;
    }
}
