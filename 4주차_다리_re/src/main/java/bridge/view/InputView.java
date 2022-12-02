package bridge.view;

import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String REQUEST_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String REQUEST_BRIDGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String REQUEST_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final InputValidator inputValidator = new InputValidator();

    private String readInput(String request){
        System.out.println(request);
        return Console.readLine();
    }

    public int readBridgeSize() {
        try{
            return inputValidator.validateLength(readInput(REQUEST_LENGTH));
        }catch (IllegalArgumentException e){
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try{
            return inputValidator.validateBridgeChoice(readInput(REQUEST_BRIDGE));
        }catch (IllegalArgumentException e){
            return readMoving();
        }
    }
    public String readGameCommand() {
        try{
            return inputValidator.validateGameRetrialChoice(readInput(REQUEST_RETRY));
        }catch (IllegalArgumentException e){
            return readGameCommand();
        }
    }
}
