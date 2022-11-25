package baseball.exception;

public class GameStatusException {

    private static final String NOT_RIGHT_GAME_STATUS_EXCEPTION = "[ERROR] 입력은 1 또는 2를 입력해야 합니다.";

    private static final String ONE = "1";
    private static final String TWO = "2";

    public String validate(String input){
        if(isNotOne(input) || isNotTwo(input)) notRightGameStatusException();
        return input;
    }

    private boolean isNotOne(String input){
        return !input.equals(ONE);
    }

    private boolean isNotTwo(String input){
        return !input.equals(TWO);
    }

    private void notRightGameStatusException(){
        System.out.println(NOT_RIGHT_GAME_STATUS_EXCEPTION);
        throw new IllegalArgumentException();
    }
}
