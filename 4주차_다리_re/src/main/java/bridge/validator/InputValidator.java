package bridge.validator;

import java.util.regex.Pattern;

import static bridge.enums.BridgeStatus.DOWN;
import static bridge.enums.BridgeStatus.UPPER;

public class InputValidator {

    private static final int MINIMUM = 3;
    private static final int MAXIMUM = 20;
    private static final String LENGTH_EXCEPTION  ="[ERROR] 다리의 길이는 3부터 20의 정수여야 합니다.";
    private static final String BRIDGE_EXCEPTION = "[ERROR] 다리는 위는 U, 아래는 D로만 입력해주셔야 합니다.";


    public int validateLength(String input){
        if(isNotNumber(input) && isOutOfRange(Integer.parseInt(input)))
            throwLengthException();
        return Integer.parseInt(input);
    }

    private boolean isNotNumber(String input){
        return !Pattern.matches("^[0-9]*$", input);
    }

    private boolean isOutOfRange(int input){
        return input < MINIMUM || input > MAXIMUM;
    }

    private void throwLengthException(){
        System.out.println(LENGTH_EXCEPTION);
        throw new IllegalArgumentException();

    }

    public String validateBridgeChoice(String input){
        if(isNotU(input) && isNotD(input)) throwChoiceException();
        return input;
    }

    private boolean isNotU(String input){
        return !input.equals(UPPER.getCommand());
    }

    private boolean isNotD(String input){
        return !input.equals(DOWN.getCommand());
    }

    private void throwChoiceException(){
        System.out.println(BRIDGE_EXCEPTION);
        throw new IllegalArgumentException();
    }

    public String validateGameRetrialChoice(String input){
        return null;
    }
}
