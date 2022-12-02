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

    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean isAllCorrect(){
        return false;
    }

    public boolean containsWrongAnswer(){
        return false;
    }

    public boolean isGameResultQuit(){
        return false;
    }

    public void quitGame(){

    }

    public String makePlayerAnswerBridge(){
        return null;
    }

    public int getTrialCount(){
        return 0;
    }
}
