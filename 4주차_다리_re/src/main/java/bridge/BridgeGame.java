package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeConstructor;
import bridge.domain.GameResult;
import bridge.domain.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Player player = new Player();
    private Bridge bridge;
    private final GameResult gameResult = new GameResult();
    private final BridgeConstructor bridgeConstructor= new BridgeConstructor;

    public BridgeGame(int size){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public void move(String input) {
        player.addPlayerAnswer(bridge
                .isCorrectAnswer(player.getAnswersCount(), input));
    }
    public void retry() {
        player.clearAnswers();
        gameResult.resetGame();
    }

    public boolean isAllCorrect(){
        return player.isFinished(bridge.getBridgesLength());
    }

    public boolean containsWrongAnswer(){
        return player.isFailedGame();
    }

    public boolean isGameResultQuit(){
        return gameResult.isQuit();
    }

    public void quitGame(){
        gameResult.failGame();
    }

    public String makePlayerAnswerBridge(){
        return bridgeConstructor
                .constructBridges(bridge.getBridges()
                        , player.getPlayerAnswers());
    }

    public int getTrialCount(){
        return gameResult.getTrialCount();
    }
}
