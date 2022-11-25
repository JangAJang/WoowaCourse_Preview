package baseball.exception;

import java.util.regex.Pattern;

public class PlayerInputException {

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

    }
}
