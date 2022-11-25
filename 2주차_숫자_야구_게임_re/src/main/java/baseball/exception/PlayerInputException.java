package baseball.exception;

public class PlayerInputException {

    public String validate(String input){
        return input;
    }

    private boolean isNotNumber(String input){
        return false;
    }

    private boolean isNotThreeDigit(String input){
        return false;
    }

    private boolean containsZero(String input){
        return false;
    }

    private void notRightPlayerNumberException(){

    }
}
