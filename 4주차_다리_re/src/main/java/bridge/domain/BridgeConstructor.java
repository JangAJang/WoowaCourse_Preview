package bridge.domain;

import java.util.List;

import static bridge.enums.BridgeMakingElements.*;
import static bridge.enums.BridgeStatus.DOWN;
import static bridge.enums.BridgeStatus.UPPER;

public class BridgeConstructor {

    private StringBuilder upperBuilder;
    private StringBuilder downBuilder;

    public String constructBridges(List<String> bridges, List<Boolean> answers){
        initializeConstructor();
        constructEachBridge(bridges.get(0), answers.get(0));
        for(int index = 1; index < answers.size(); index++){
            upperBuilder.append(DIVIDER.getElement());
            downBuilder.append(DIVIDER.getElement());
            constructEachBridge(bridges.get(index), answers.get(index));
        }
        return concludeBuilder();
    }

    private String concludeBuilder(){
        upperBuilder.append(FINISHER.getElement());
        downBuilder.append(FINISHER.getElement());
        return upperBuilder+"\n"+downBuilder;
    }

    private void initializeConstructor(){
        upperBuilder = new StringBuilder();
        upperBuilder.append(STARTER.getElement());
        downBuilder = new StringBuilder();
        downBuilder.append(STARTER.getElement());
    }

    private void constructEachBridge(String bridgeEach, boolean answerEach){
        if(isUpperBridge(bridgeEach)) {
            writeUpperToAnswer(answerEach);
            return;
        }
        writeDOWNToAnswer(answerEach);
    }

    private boolean isUpperBridge(String bridgeEach){
        return bridgeEach.equals(UPPER.getCommand());
    }

    private void writeUpperToAnswer(boolean answerEach){
        if(answerEach) {
            upperBuilder.append(CORRECT.getElement());
            downBuilder.append(EMPTY.getElement());
            return;
        }
        upperBuilder.append(EMPTY.getElement());
        downBuilder.append(WRONG.getElement());
    }

    private void writeDOWNToAnswer(boolean answerEach){
        if(answerEach) {
            upperBuilder.append(EMPTY.getElement());
            downBuilder.append(CORRECT.getElement());
            return;
        }
        upperBuilder.append(WRONG.getElement());
        downBuilder.append(EMPTY.getElement());
    }
}
