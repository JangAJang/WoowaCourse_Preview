package baseball.exception;

import java.util.regex.Pattern;

public class PlayerInputException {

    private static final String NOT_RIGHT_PLAYER_INPUT_EXCEPTION = "[ERROR] 입력은 1~9로 이루어진 숫자 3개여야 합니다";

    public String validate(String input){
        return input;
    }

    private boolean isNotNumber(String input){
        return !Pattern.matches("^[1-9]*$", input);
    }

    private boolean isNotThreeDigit(String input){
        return input.length()!= 3;
    }

    private boolean containsZero(String input){
        return input.contains("0");
    }

    private void notRightPlayerNumberException(){
        System.out.println(NOT_RIGHT_PLAYER_INPUT_EXCEPTION);
        throw new IllegalArgumentException();
    }
}
