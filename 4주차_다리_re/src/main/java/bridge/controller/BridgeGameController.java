package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.enums.GameStatus.QUIT;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;

    public BridgeGameController(){
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
    }

    private void moveAStep(){
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.makePlayerAnswerBridge());
    }

    private void resetGame(){
        bridgeGame.retry();
    }

    private void concludeGame(){
        outputView.printFinalMap(bridgeGame.makePlayerAnswerBridge());
        outputView.printResult(!bridgeGame.isAllCorrect(), bridgeGame.getTrialCount());
    }

    public void runGame(){
        while(true){
            moveUntilStop();
            if(bridgeGame.isAllCorrect()) break;
            if(isQuit()) break;
            resetGame();
        }
        concludeGame();
    }

    private boolean isQuit(){
        return readFinalCommand().equals(QUIT.getCommand());
    }

    private void moveUntilStop(){
        while(!(bridgeGame.isAllCorrect()) || bridgeGame.containsWrongAnswer()){
            moveAStep();
        }
    }

    private String readFinalCommand(){
        return inputView.readGameCommand();
    }
}
