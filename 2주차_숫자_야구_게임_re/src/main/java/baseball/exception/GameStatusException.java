package baseball.exception;

public class GameStatusException {

    private static final String ONE = "1";
    private static final String TWO = "2";

    public String validate(String input){
        return input;
    }

    private boolean isNotOne(String input){
        return input.equals(ONE);
    }

    private boolean isNotTwo(String input){
        return false;
    }

    private void notRightGameStatusException(){

    }
}
