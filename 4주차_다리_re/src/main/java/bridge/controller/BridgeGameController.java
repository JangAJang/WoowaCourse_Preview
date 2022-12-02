package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.enums.GameStatus.QUIT;

public class BridgeGameController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame;

    public BridgeGameController(){
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
    }

    public void runGame(){
        while(isRunning()){

        }
    }

    private boolean isRunning(){
        return !(bridgeGame.isAllCorrect() || bridgeGame.isGameResultQuit());
    }

    private boolean isStopMoment(){
        return bridgeGame.isAllCorrect() || bridgeGame.containsWrongAnswer();
    }

    private void movePlayer(){
        bridgeGame.move(inputView.readGameCommand());
        outputView.printMap(bridgeGame.makePlayerAnswerBridge());
    }

    private void moveUntilStopMoment(){
        while(!isStopMoment()){
            movePlayer();
        }
    }

    private void retryGame(){
        if(isRunning()) bridgeGame.retry();
    }

    private void concludeGame(){
        outputView.printFinalMap(bridgeGame.makePlayerAnswerBridge());
        outputView.printResult(bridgeGame.isGameResultQuit(), bridgeGame.getTrialCount());
    }

    private void changeGameStatusIfRunning(){
        if(isRunning()) checkRetrialInput();
    }

    private void checkRetrialInput(){
        if(inputView.readGameCommand().equals(QUIT.getCommand()))
            bridgeGame.quitGame();
    }
}
