package bridge.validator;

import java.util.regex.Pattern;

public class InputValidator {

    private static final int MINIMUM = 3;
    private static final int MAXIMUM = 20;
    private static final String LENGTH_EXCEPTION  ="[ERROR] 다리의 길이는 3부터 20의 정수여야 합니다.";


    public int validateLength(String input){
        if(isNotNumber(input) || isOutOfRange(Integer.parseInt(input)))
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
        return null;
    }

    public String validateGameRetrialChoice(String input){
        return null;
    }
}
