package baseball.controller;

import baseball.model.Baseball;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Baseball baseball;

    public BaseballController(){
        initializeGame();
        createAnswer();
    }

    private void initializeGame(){
        outputView.startGame();
    }

    private void createAnswer(){
        baseball = new Baseball();
    }

    private void makePlayer(){
        baseball.createPlayer(inputView.readPlayerNumber());
    }

}
