package baseball.model;

import baseball.domain.Player;
import baseball.domain.RandomNumbers;

public class Baseball {

    private static final int THREE_STRIKE = 3;

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
        return randomNumbers.countBall(player.getNumbers());
    }

    public boolean isThreeStrike(){
        return countStrikeWithPlayer() == THREE_STRIKE;
    }
}
