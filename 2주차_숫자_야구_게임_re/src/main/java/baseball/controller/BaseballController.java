package baseball.controller;

import baseball.model.Baseball;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private static final String QUIT = "2";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Baseball baseball;

    public BaseballController(){
        initializeGame();
        createAnswer();
    }

    public void runGame(){
        while(true){
            playUntilFinish();
            if (isOutputQuit()) break;
            resetGame();
        }
    }

    private void playUntilFinish(){
        do{
            makePlayer();
            concludeRound();
        }while(!isThreeStrike());
        printFinish();
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

    private void concludeRound(){
        outputView.printScore(baseball.countBallWithPlayer()
                , baseball.countStrikeWithPlayer());
    }

    private boolean isThreeStrike(){
        return baseball.isThreeStrike();
    }

    private boolean isOutputQuit(){
        return inputView.readGameCommand().equals(QUIT);
    }

    private void printFinish(){
        outputView.printSuccess();
    }

    private void resetGame(){
        baseball = new Baseball();
    }
}
