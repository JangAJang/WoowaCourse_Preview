package baseball.controller;

import baseball.domain.Player;
import baseball.domain.RandomNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Player player;
    private RandomNumbers randomNumbers;

    public BaseballController(){

    }

    private void initializeGame(){
        outputView.startGame();
    }

}
